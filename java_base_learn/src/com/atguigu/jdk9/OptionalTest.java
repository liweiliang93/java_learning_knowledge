package com.atguigu.jdk9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * @author liweiliang
 * @create 2022-11-27 15:30
 * @description Optional新方法测试
 */
public class OptionalTest {
    @Test   //Optional新方法stream()
    public void test(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Tom");
        list.add("Jack");
        list.add("Tim");
        Optional<ArrayList<String>> list1 = Optional.of(list);
        list1.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
