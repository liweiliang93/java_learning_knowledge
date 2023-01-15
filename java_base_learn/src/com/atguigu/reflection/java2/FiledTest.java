package com.atguigu.reflection.java2;

import com.atguigu.reflection.java1.Person1;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author liweiliang
 * @create 2022-11-20 22:45
 * @description 获取运行时类的属性结构
 */
public class FiledTest {
    @Test
    public void test(){
        //1.getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Class clazz = Person1.class;
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("-------------------------------------");

        //2.getDeclaredFields():获取当前运行时类中声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }

    @Test//权限修饰符、数据类型、变量名
    public void test1(){
        Class clazz = Person1.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符 Modifier.toString()
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+ " ");
            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");
            //3.变量名
            String fName = f.getName();
            System.out.print(fName + "\t");
            System.out.println();
        }
    }
}
