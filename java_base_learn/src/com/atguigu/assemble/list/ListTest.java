package com.atguigu.assemble.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author liweiliang
 * @create 2022-10-11 17:09
 * @description
 */
public class ListTest {
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(new String("Tom"));
        list.add(new Person(14,"Tom"));
        list.add("AA");
        list.add(567);
        list.add(2);

        //Iterator迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //方式二：for循环
        for (Object obj : list){
            System.out.println(obj);
        }
        //方式三:foreac方法
        list.forEach(System.out::println);

        list.remove(2);
        list.remove(new Integer(2));
    }

}

class Person{
    private int age;
    private String name;

    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

}
