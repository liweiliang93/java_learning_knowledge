package com.atguigu.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liweiliang
 * @create 2022-11-20 20:11
 * @description 了解类的加载器
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //自定义类使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent():获取拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用拓展类加载器的getParent():无法获取加载器
        //引导类加载器主要负责加载java的核心类库,无法加载自定义类的
        System.out.println(classLoader1.getParent());
        //String等核心类库是引导类加载器加载的
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);
    }

    @Test   //读取配置文件的方式一:此时文件默认在当前工程下
    public void test2() throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);
        String user = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = "+user + ", password = "+password);
    }
    @Test   //读取配置文件的方式二：使用ClassLoader的getResourceAsStream()方法,默认路径在src下
    public void test3() throws IOException {
        Properties pros = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(resourceAsStream);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ", password = "+password);
    }
}
