package com.atguigu.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author liweiliang
 * @create 2022-11-20 20:44
 * @description
 */
public class NewInstanceTest {
//    @Test
//    public void test() throws InstantiationException, IllegalAccessException {
//        Class<Person> clazz = Person.class;
//        /*
//         * newInstance()方法：调用此方法,创建对应的运行时类的对象,调用运行时类的空参构造器
//         * 要想此方法正常的创建运行时类的对象,要求:运行时类必须提供足够权限的空参的构造器(public、缺省)
//         *
//         * 在javabean中要求提供一个public的空参构造器,原因是:
//         * 1.便于通过反射，创建运行时类的对象
//         * 2.便于子类继承此运行时类，默认使用super()时,保证父类有此构造器
//         */
//        Person ps = clazz.newInstance();
//        System.out.println(ps);
//    }

    @Test
    public void test1(){
        for(int i = 0;i < 100;i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.String";
                    break;
                case 2:
                    classPath = "com.atguigu.reflection.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /*
        创建一个指定类的对象
        classPath:指定类的全类名
         */
    public Object getInstance(String classPath) throws Exception {
        Class<?> calzz = Class.forName(classPath);
        return calzz.newInstance();
    }

}
