package com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.data.entity.LoginMngmtEntity;
import com.demo.data.service.LoginMngmtService;

@Controller
@RequestMapping("/")
public class TestController {
   @Autowired
   private LoginMngmtService loginMngmtService;

  @RequestMapping("/test")
  @ResponseBody
  public String home() {
      String returnStr = "";
      LoginMngmtEntity inputEntity = new LoginMngmtEntity();

      inputEntity.setLoginId("11111");

      LoginMngmtEntity outputEntity = loginMngmtService.getOneFindAll(inputEntity);

      returnStr = outputEntity.toString();

      return returnStr;
  }



}
