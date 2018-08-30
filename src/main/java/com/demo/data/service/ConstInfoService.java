package com.demo.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.data.entity.ConstInfoEntity;
import com.demo.data.mapper.ConstInfoMapper;
import com.demo.data.repository.ConstInfoRepository;

@Service
@Transactional
public class ConstInfoService {

    @Autowired
    private ConstInfoMapper constInfoMapper;

    @Autowired
    private ConstInfoRepository constInfoRepository;

    public ConstInfoEntity findOne(String employeeId){
        return constInfoMapper.selectByPk(employeeId);
    }

    public List<ConstInfoEntity> findAll(){

        return constInfoRepository.findAll();

    }

}
