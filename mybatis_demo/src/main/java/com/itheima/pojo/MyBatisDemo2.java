package com.itheima.pojo;

import com.itheima.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liweiliang
 * @create 2023-01-03 18:42
 * @description MyBatis的代理开发
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //获取信息
        int id = 1;
        String username = "n";
        String password = "1";
        //处理信息
        username = "%" + username + "%";
        password =  "%" + password + "%";
        Map map = new HashMap();
//        map.put("id",id);
//        map.put("username",username);
        map.put("password",password);
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectByCondition(map);
        System.out.println(users);
        sqlSession.close();
    }
}
