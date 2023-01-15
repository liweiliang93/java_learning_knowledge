package com.atguigu.reflection.java1;

/**
 * @author liweiliang
 * @create 2022-11-20 21:48
 * @description
 */
@MyAnnotation(value = "hi")
public class Person1 extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;
    private static int Id;

    public Person1() {
    }
    @MyAnnotation(value = "abc")
    private Person1(String name){
        this.name = name;
    }
    Person1(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "操你的批")
    private String show(String nation) throws Exception{
        System.out.println("我的国籍是:"+nation);
        return nation;
    }

    public String display(String interests,String name,int age){
        return interests + age;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
    @Override
    public void info() {
        System.out.println("我是一个人");
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }
}
