package com.hftang.mybatis;

import com.hftang.mybatis.mapper.UserMapper;
import com.hftang.mybatis.pojo.QueryVo;
import com.hftang.mybatis.pojo.User;
import com.hftang.mybatis.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void findUserById() {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession();
        //获取接口的代理对象 实现类不用自己去写
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void getUserByName() {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("张");
        user.setSex("1");
        List<User> list = mapper.getUserByName(user);
        for (User item : list) {
            System.out.println(item);
        }


    }

    @Test
    public void insertUser() {
    }


    @Test
    public void testForeach() {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession(true);
        QueryVo queryVo = new QueryVo();
        // 1,10,16,28,29
        queryVo.setUserIds(Arrays.asList(1,10,16,28,29));
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findUserByIds(queryVo);
        for (User item : userList) {
            System.out.println(item);
        }

    }







}