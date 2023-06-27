package com.itweiliang.educoder.gui.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author liweiliang
 * @create 2023-04-09 16:37:00
 * @description
 */
public class DbUtil {
    private String dbDiver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:13306/db1?characterEncoding=utf-8";
    private String dbUsername ="root";
    private String dbPassword = "liang521..";
    public Connection getConnection() throws Exception{
        Class.forName(dbDiver);
        Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        return con;
    }
    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }
}