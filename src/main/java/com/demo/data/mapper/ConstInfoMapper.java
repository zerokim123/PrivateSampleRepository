package com.demo.data.mapper;

import com.demo.data.entity.ConstInfoEntity;

public interface ConstInfoMapper {

    ConstInfoEntity selectByPk(String constCode);
}
