package com.weiliang.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @author liweiliang
 * @create 2023-01-01 12:19
 * @description 用户登录中SQL注入
 */
public class JDBCDemo_UserLogin {
    @Test
    public void testSQL() throws Exception {
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "liang521..";
        Connection connection = DriverManager.getConnection(url, username, password);
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    /***
     * @author: liweiliang
     * @date: 2023/1/1 13:24
     * @param: []
     * @return: void
     * @details: 用户登录问题SQL注入解决 + 预编译检验
     **/
    @Test
    public void testResultSet() throws SQLException, InterruptedException {
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "liang521..";
        Connection connection = DriverManager.getConnection(url, username, password);
        //接收用户输入用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Thread.sleep(10000);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
