package com.demo.data.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.demo.data.entity.join.LoginEntity;
import com.demo.data.mapper.join.LoginMapper;

@Component
public class LoginServiceImpl implements UserDetailsService {

  @Autowired
  private LoginMapper loginMapper;

  private static String AUTH_CONDE_USER = "0";

  private static String AUTH_CONDE_ADMIN = "1";

  private static String AUTH_NAME_USER = "ROLE_USER";


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    if (StringUtils.isEmpty(username)) {
      throw new UsernameNotFoundException("");
    }

    LoginEntity user = loginMapper.loginSelectByPk(username);
    if (user == null) {
      throw new UsernameNotFoundException("");
    }

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    if (AUTH_NAME_USER.equals(user.getAuthority())) {

      user.setRole(AUTH_CONDE_USER);

    } else {
      user.setRole(AUTH_CONDE_ADMIN);
    }

    return user;
  }

}
