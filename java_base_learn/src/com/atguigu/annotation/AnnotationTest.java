package com.atguigu.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author liweiliang
 * @create 2022-10-06 17:58
 * @description 注解的使用:  JDK5.0新增的用法
 *              占据了及其重要的角色
 *             JDK内置的三种注解类型：
 *             1.@Override
 *             2.@Deprecated
 *             3.@SuppressWarnings
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person = new Student();
        person.eat();
        person.sleep();

        Date date = new Date(2002,23,23);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;

        @SuppressWarnings({ "unused", "rawtypes" })
        ArrayList arrayList = new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i]);
        }
    }
}

@MyAnnotation(value = "草丛")
@MyAnnotation(value = "尼玛")
class Person{
    private int age;
    private String name;

    public Person(){}

    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{
    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
    @Override
    public void show() {
        System.out.println("展示");
    }
}

class Generic<@MyAnnotation T>{
    public void show() throws RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int number = (@MyAnnotation int)10L;
    }
}