package com.itheima.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liweiliang
 * @create 2023-10-02 13:36:43
 * @description
 */
public class SqlSessionFactoryUtils {
    //声明sqlSessionFactory静态对象,只加载一次
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块内获取sqlSessionFactory对象,只生成一次
    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //通过getSqlSessionFactory()方法获取同一个sqlSessionFactory,防止资源浪费.
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}