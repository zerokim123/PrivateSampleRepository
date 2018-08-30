package com.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.data.entity.ConstInfoEntity;
import com.demo.data.entity.EmployeeInfoEntity;
import com.demo.data.entity.WorkDateInfoEntity;
import com.demo.data.entity.join.LoginEntity;
import com.demo.data.service.ConstInfoService;
import com.demo.data.service.EmployeeInfoService;
import com.demo.data.service.WorkDateInfoService;
import com.demo.web.common.service.GetLoginInfoService;
import com.demo.web.form.IndexForm;
import com.demo.web.form.WorkDateInfoForm;

@Controller
@RequestMapping("/")
public class TopController {

    @Autowired
    private GetLoginInfoService getLoginInfo;

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private WorkDateInfoService workDateInfoService;

    @Autowired
    private ConstInfoService constInfoService;

    @RequestMapping(value = "/", method = {RequestMethod.GET} )
    public String index(Model model){

        LoginEntity loginInfoInput = getLoginInfo.loginInfo();
        model.addAttribute("loginInfo",loginInfoInput);

        EmployeeInfoEntity loginInfo = employeeInfoService.findOne(loginInfoInput.getEmployeeId());

        IndexForm indexForm = new IndexForm();

        indexForm.setEmployeeId(loginInfo.getEmployeeId());
        indexForm.setFirstName(loginInfo.getFirstName());
        indexForm.setLastName(loginInfo.getLastName());
        ConstInfoEntity constInfo = constInfoService.findOne(loginInfo.getConstCode());
        indexForm.setConstName(constInfo.getConstName());

        List<WorkDateInfoEntity> workList = workDateInfoService.selectByEmployeeId(loginInfoInput.getEmployeeId());
        List<WorkDateInfoForm> workDateFormList = new ArrayList<WorkDateInfoForm>(0);

        for (WorkDateInfoEntity workDateInfoEntity : workList) {
            WorkDateInfoForm workDateInfoForm = new WorkDateInfoForm();
            workDateInfoForm.setWorkYear(workDateInfoEntity.getWorkYear());
            workDateInfoForm.setWorkMonth(workDateInfoEntity.getWorkMonth());
            workDateInfoForm.setConstName(workDateInfoEntity.getConstName());
            workDateInfoForm.setWorkDate(workDateInfoEntity.getWorkDate());
            workDateFormList.add(workDateInfoForm);
        }
        indexForm.setWorkDateInfoFormList(workDateFormList);

        model.addAttribute("indexForm",indexForm);

        return "index";
    }

}