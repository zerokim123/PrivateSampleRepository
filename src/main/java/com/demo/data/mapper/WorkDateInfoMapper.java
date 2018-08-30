package com.demo.data.mapper;

import java.util.List;

import com.demo.data.entity.WorkDateInfoEntity;

public interface WorkDateInfoMapper {

    List<WorkDateInfoEntity> selectByEmployeeId(String employeeId);
}
