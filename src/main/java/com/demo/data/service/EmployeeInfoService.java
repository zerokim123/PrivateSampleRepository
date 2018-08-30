package com.demo.data.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.data.entity.EmployeeInfoEntity;
import com.demo.data.mapper.EmployeeInfoMapper;
import com.demo.data.repository.EmployeeInfoRepository;

@Service
@Transactional
public class EmployeeInfoService {

  @Autowired
  private EmployeeInfoMapper employeeInfoMapper;

  @Autowired
  private EmployeeInfoRepository employeeInfoRepository;

  public EmployeeInfoEntity findOne(String employeeId) {
    return employeeInfoMapper.selectByPk(employeeId);
  }

  public List<EmployeeInfoEntity> findAll() {

    return employeeInfoRepository.findAll();

  }


}
