package com.atguigu.assemble.map;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author liweiliang
 * @create 2022-10-18 11:56
 * @description
 */
public class CollectionTest1 {
    @Test
    public void test(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1); //并未删除成功，根据现在的hash值寻找到其他的地址
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}
