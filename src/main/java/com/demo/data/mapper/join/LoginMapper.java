package com.demo.data.mapper.join;

import com.demo.data.entity.join.LoginEntity;

public interface LoginMapper {
  LoginEntity loginSelectByPk(String loginId);

}
