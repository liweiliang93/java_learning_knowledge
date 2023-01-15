package com.weiliang.jdbc;

import com.weiliang.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-01-01 11:32
 * @description 查询account账户表数据，封装为Account对象中，并且存储到ArrayList对象中
 */
public class JDBCDemo_ResultSet {
    @Test
    public void testResultSet() throws Exception {
        String url = "jdbc:mysql:///atguigudb?useSSL=false";
        String username = "root";
        String password = "liang521..";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from account";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Account> list = new ArrayList<>();
        while(resultSet.next()){
            Account account = new Account();
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            list.add(account);
        }
        System.out.println(list);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
