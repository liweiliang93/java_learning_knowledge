package com.atguigu.assemble.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author liweiliang
 * @create 2022-10-23 22:49
 * @description
 */
public class PropertiesTest {
    public static void main(String[] args){
        //Properties常用来配置文件。key和value都是String类型
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流的对应文件
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name = " + name + " password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
