package com.atguigu.java.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author liweiliang
 * @create 2022-11-22 22:16
 * @description
 */
public class LambdaTest {
    @Test
    public void test(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
    }
    @Test
    public void test1(){
        Runnable r1 = ()-> System.out.println("我爱北京故宫");
        r1.run();
    }
    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com1.compare(12, 21);
        System.out.println(compare);
        System.out.println("---------------------------");
        Comparator<Integer> com2 = Integer::compare;
        int compare1 = com2.compare(12, 23);
        System.out.println(compare1);
    }
}
