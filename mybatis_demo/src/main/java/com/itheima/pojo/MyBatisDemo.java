package com.itheima.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-01-03 17:03
 * @description MyBatis的快速入门
 */

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载myBatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取对应的SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);
        //4.释放资源
        sqlSession.close();
    }
}
