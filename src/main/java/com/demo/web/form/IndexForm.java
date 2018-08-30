package com.demo.web.form;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IndexForm{

    private String employeeId;

    private String firstName;

    private String lastName;

    private String constName;

    private List<WorkDateInfoForm>  workDateInfoFormList;

}
