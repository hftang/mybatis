package com.hftang.mybatis;

import com.hftang.mybatis.pojo.Order;
import com.hftang.mybatis.pojo.User;
import com.hftang.mybatis.utils.SessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMain {


    @Test
    public void run01() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.getUserById", 1);

        System.out.println(user);

        sqlSession.close();


    }

    @Test
    public void run02() {

        SqlSessionFactory sessionFactory = SessionFactoryUtils.getInstance();
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> list = sqlSession.selectList("user.findUserByName", "张");
        for (User user : list) {
            System.out.println(user);
        }

    }


    @Test
    public void run03() {
        SqlSessionFactory sessionFactory = SessionFactoryUtils.getInstance();
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();

//        user.setAddress("北京昌平22");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setUsername("汤化峰");
        int insert = sqlSession.insert("user.insertUser", user);

        System.out.println(insert + "------->");

        // [id=30, username=汤化峰, sex=1, birthday=Fri Sep 14 14:01:26 CST 2018, address=北京昌平]
        System.out.println(insert + "------->" + user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void run04() {
        SqlSessionFactory sessionFactory = SessionFactoryUtils.getInstance();
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("汤化峰--》");
        sqlSession.update("user.updateUserById", user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteOrderById() {

        SqlSessionFactory sqlSessionFactory = SessionFactoryUtils.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Order order = new Order();
        order.setId(4);

        int delete = sqlSession.delete("user.deleteOrderById", order);
        sqlSession.commit();
        sqlSession.close();


    }


}
