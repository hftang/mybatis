package com.hftang.mybatis.dao;

import com.hftang.mybatis.pojo.User;

import java.util.List;

public interface UserDao {

    User findUserById(Integer id);

    List<User> getUserByName(String name);

    void insertUser(User user);
}
