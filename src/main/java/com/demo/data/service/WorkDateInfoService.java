package com.demo.data.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.data.entity.WorkDateInfoEntity;
import com.demo.data.mapper.WorkDateInfoMapper;
import com.demo.data.repository.WorkDateInfoRepository;

@Service
@Transactional
public class WorkDateInfoService {

  @Autowired
  private WorkDateInfoMapper workDateInfoMapper;

  @Autowired
  private WorkDateInfoRepository workDateInfoRepository;


  public List<WorkDateInfoEntity> selectByEmployeeId(String employeeId) {
    return workDateInfoMapper.selectByEmployeeId(employeeId);
  }

  public void save(WorkDateInfoEntity workDateInfoEntity) {
    workDateInfoRepository.save(workDateInfoEntity);
  }

}
