package com.hftang.mybatis.dao;

import com.hftang.mybatis.dao.daoImpl.UserDaoImpl;
import com.hftang.mybatis.pojo.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void findUserById() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(1);
        System.out.println(user);

    }

    @Test
    public void getUserByName() {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.getUserByName("张");
        for (User item : list) {

            System.out.println(item);

        }
    }

    @Test
    public void insertUser() {
        UserDao userDao=new UserDaoImpl();
        User user = new User();
        user.setUsername("糖化断点");
        user.setBirthday(new Date());
        userDao.insertUser(user);
    }
}