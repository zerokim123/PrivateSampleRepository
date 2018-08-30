package com.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.data.entity.ConstInfoEntity;

@Repository
public interface ConstInfoRepository extends JpaRepository<ConstInfoEntity, String>,
    JpaSpecificationExecutor<ConstInfoEntity>, CrudRepository<ConstInfoEntity, String> {

}
