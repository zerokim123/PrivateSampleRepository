package com.demo.web.common.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.demo.data.entity.join.LoginEntity;

@Service
public class GetLoginInfoService {

    private static String AUTH_CODE_USER = "0";

    public LoginEntity loginInfo() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        LoginEntity loginInfo = (LoginEntity)principal;

        if (AUTH_CODE_USER.equals(loginInfo.getRole())) {
            loginInfo.setRoleName("利用者");
        } else {
            loginInfo.setRoleName("管理者");
        }
        return loginInfo;

    }

}
