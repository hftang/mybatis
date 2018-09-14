package com.hftang.mybatis.dao.daoImpl;

import com.hftang.mybatis.dao.UserDao;
import com.hftang.mybatis.pojo.User;
import com.hftang.mybatis.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserById(Integer id) {
        SqlSessionFactory sqlSessionFactory = SessionFactoryUtils.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession();
        List<User> list = sqlSession.selectList("user.findUserByName", name);
        sqlSession.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = SessionFactoryUtils.getInstance().openSession();
        sqlSession.insert("user.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
