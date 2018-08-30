package com.demo.data.mapper;

import com.demo.data.entity.EmployeeInfoEntity;

public interface EmployeeInfoMapper {

    EmployeeInfoEntity selectByPk(String employeeId);
}
