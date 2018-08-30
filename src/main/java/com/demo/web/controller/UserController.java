package com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.data.entity.join.LoginEntity;
import com.demo.web.common.service.GetLoginInfoService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private GetLoginInfoService getLoginInfo;

  @RequestMapping(value = "userInfo", method = RequestMethod.GET)
  public String index(Model model) {

    LoginEntity loginInfo = getLoginInfo.loginInfo();

    model.addAttribute("loginInfo", loginInfo);

    return "user/userInfo";
  }


}
