package com.weiliang.pojo.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.weiliang.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author liweiliang
 * @create 2023-01-01 16:46
 * @description 品牌数据的查询操作
 */
public class BrandTest {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\project\\java_project (idea)\\java_database_connectivity\\src/druid.properties"));
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        //3.定义sql
        String sql = "select * from tb_brand";
        //4.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.设置参数
        //6.执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        //7.处理结果封装到List集合内
        List<Brand> brands = new ArrayList<>();
        Brand brand = null;
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String brandName = resultSet.getString(2);
            String companyName = resultSet.getString(3);
            int ordered = resultSet.getInt(4);
            String description = resultSet.getString(5);
            int status = resultSet.getInt(6);
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            brands.add(brand);
        }
        System.out.println(brands);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    /***
    * @author: liweiliang
    * @date: 2023/1/1 17:04
    * @param: []
    * @return: void
    * @details: 品牌数据的添加操作
    **/
    @Test
    public void testAdd() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\project\\java_project (idea)\\java_database_connectivity\\src/druid.properties"));
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        //3.定义sql
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";
        //4.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        //6.执行sql
        int count = preparedStatement.executeUpdate();
        System.out.println(count > 0);
        preparedStatement.close();
        connection.close();
    }
    /***
     * @author: liweiliang
     * @date: 2023/1/1 17:04
     * @param: []
     * @return: void
     * @details: 品牌数据的添加操作
     **/
    @Test
    public void testModify() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\project\\java_project (idea)\\java_database_connectivity\\src/druid.properties"));
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        //3.定义sql
        String sql = " update tb_brand\n" +
                "         set brand_name  = ?,\n" +
                "         company_name= ?,\n" +
                "         ordered     = ?,\n" +
                "         description = ?,\n" +
                "         status      = ?\n" +
                "     where id = ?";
        //4.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);
        //6.执行sql
        int count = preparedStatement.executeUpdate();
        System.out.println(count > 0);
        preparedStatement.close();
        connection.close();
    }
    /***
     * @author: liweiliang
     * @date: 2023/1/1 17:04
     * @param: []
     * @return: void
     * @details: 品牌数据的删除操作
     **/
    @Test
    public void testDelete() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;
        //1.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("E:\\project\\java_project (idea)\\java_database_connectivity\\src/druid.properties"));
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        //3.定义sql
        String sql = "delete from tb_brand where id = ?";
        //4.获取pstmt对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.设置参数
        preparedStatement.setInt(1,id);
        //6.执行sql
        int count = preparedStatement.executeUpdate();
        System.out.println(count > 0);
        preparedStatement.close();
        connection.close();
    }
}
