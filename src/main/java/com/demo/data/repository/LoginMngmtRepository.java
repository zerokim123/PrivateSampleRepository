package com.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.data.entity.LoginMngmtEntity;

@Repository
public interface LoginMngmtRepository extends JpaRepository<LoginMngmtEntity, String>,
    JpaSpecificationExecutor<LoginMngmtEntity>, CrudRepository<LoginMngmtEntity, String> {

  public LoginMngmtEntity findByLoginId(String loginId);

}
