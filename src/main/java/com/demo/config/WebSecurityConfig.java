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
        httpSecurity
                .authorizeRequests()
                  .antMatchers("/css/**", "/images/**", "/js/**", "/login", "/test").permitAll() // /loginは認証なしでアクセス可能
                  .antMatchers("/admin,/admin/*,/admin/**").hasRole("ADMIN") // ADMINユーザーのみアクセス可能
                  .antMatchers("/user,/user/*,/user/**").hasRole("USER") // USERユーザーのみアクセス可能
                  .anyRequest()
                  .authenticated()
                .and()
                  .formLogin()
                  .loginPage("/login") // ログインページ
                  .defaultSuccessUrl("/") // 認証成功時の遷移先
//                  .failureUrl("/login?error")
                  .failureHandler(new SampleAuthenticationFailureHandler())
                  .usernameParameter("username") // ユーザー名のパラメータ
                  .passwordParameter("password") // パスワードのパラメータ
                  .permitAll()
                .and()
                  .logout()
                  .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理のパス
                  .logoutSuccessUrl("/login") // ログイン完了後のパス
                  .permitAll();

//        // ログイン設定
//        httpSecurity
//                .formLogin()
//                .loginProcessingUrl("/login") // 認証処理用
//                .loginPage("/login") // ログインページ
//                .failureUrl("/login-error")
//                .failureHandler(new SampleAuthenticationFailureHandler()) // 認証失敗時のハンドラクラス
//                .usernameParameter("username") // ユーザー名のパラメータ
//                .passwordParameter("password") // パスワードのパラメータ
//                .defaultSuccessUrl("/") // 認証成功時の遷移先
//                .and();
//
//        // ログアウト設定
//        httpSecurity
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理のパス
//                .logoutSuccessUrl("/login"); // ログイン完了後のパス
    }

    @Autowired
    private LoginServiceImpl loginService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        super.configure(auth);
        auth.userDetailsService(loginService);
    }


//    @Configuration
//    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        private LoginServiceImpl loginService;
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            // 認証するユーザーを設定する
//            auth.userDetailsService(loginService);
//        }
//    }

}