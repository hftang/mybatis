package com.hftang.mybatis;

import com.hftang.mybatis.mapper.OrderMapper;
import com.hftang.mybatis.pojo.OrderUser;
import com.hftang.mybatis.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest {

    @Test
    public void getOrderUser() {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderUser> list = mapper.getOrderUser();
        for (OrderUser item : list) {

            System.out.println(item);
        }


    }
}