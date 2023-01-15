package com.atguigu.assemble.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author liweiliang
 * @create 2022-10-13 9:16
 * @description
 */
public class SetList {
    @Test
    public void test(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(new String("Tom"));
        set.add("name");
        set.add(123);
        set.add(new Person(12,"Tom"));
        set.add(new User(12,"Tom"));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Person{
    private int age;
    private String name;

    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


}