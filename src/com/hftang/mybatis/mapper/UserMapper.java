package com.hftang.mybatis.mapper;

import com.hftang.mybatis.pojo.QueryVo;
import com.hftang.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    User findUserById(Integer id);

    List<User> getUserByName(User user);

    void insertUser(User user);

    List<User> findUserByIds(QueryVo vo);
}
