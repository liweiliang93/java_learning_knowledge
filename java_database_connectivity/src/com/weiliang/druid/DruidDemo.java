package com.weiliang.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author liweiliang
 * @create 2023-01-01 16:17
 * @description Druid数据库连接池演示
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\project\\java_project (idea)\\java_database_connectivity\\src/druid.properties"));
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //3.获取数据库连接
        Connection connection = dataSource.getConnection();
    }
}
