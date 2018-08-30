package com.demo.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.data.entity.LoginMngmtEntity;
import com.demo.data.mapper.LoginMngmtMapper;
import com.demo.data.repository.LoginMngmtRepository;

@Service
@Transactional
public class LoginMngmtService {

  @Autowired
  private LoginMngmtRepository loginMngmtRepository;

  @Autowired
  private LoginMngmtMapper loginMngmtMapper;

  public LoginMngmtEntity findOne(String loginId) {
    return loginMngmtRepository.getOne(loginId);
  }

  public LoginMngmtEntity getOneFindAll(LoginMngmtEntity loginMngmtEntity) {
    return loginMngmtMapper.selectByPkFindAll(loginMngmtEntity);
  }


}
