package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.demo.data.service.impl.LoginServiceImpl;
import com.demo.handler.SampleAuthenticationFailureHandler;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    // 認可の設定
    httpSecurity.authorizeRequests()
        // /loginは認証なしでアクセス可能
        .antMatchers("/css/**", "/images/**", "/js/**", "/login", "/test").permitAll()
        // ADMINユーザーのみアクセス可能
        .antMatchers("/admin,/admin/*,/admin/**").hasRole("ADMIN")
        // USERユーザーのみアクセス可能
        .antMatchers("/user,/user/*,/user/**").hasRole("USER")
        // ログインページ
        // 認証成功時の遷移先
        // .failureUrl("/login?error")
        .anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/")
        // ユーザー名のパラメータ
        .failureHandler(new SampleAuthenticationFailureHandler()).usernameParameter("username")
        // パスワードのパラメータ
        .passwordParameter("password")
        // ログアウト処理のパス
        .permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
        // ログイン完了後のパス
        .logoutSuccessUrl("/login").permitAll();

  }

  @Autowired
  private LoginServiceImpl loginService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
    auth.userDetailsService(loginService);
  }


  // @Configuration
  // protected static class AuthenticationConfiguration extends
  // GlobalAuthenticationConfigurerAdapter {
  // @Autowired
  // private LoginServiceImpl loginService;
  //
  // @Override
  // public void init(AuthenticationManagerBuilder auth) throws Exception {
  // // 認証するユーザーを設定する
  // auth.userDetailsService(loginService);
  // }
  // }

}
