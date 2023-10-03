package com.itheima.service.impl;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-10-02 13:19:22
 * @description UserMapper操作服务实现类
 */
public class UserServiceImpl implements UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void addUser(User user) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.update(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<User> selectAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return  mapper.selectAll();
    }


}