package com.atguigu.jdk10;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author liweiliang
 * @create 2022-11-27 16:35
 * @description
 */
public class Java10Test {
    @Test
    public void test(){
        var num = 10;
        var list = new ArrayList<Integer>();
        list.add(12);
        for(var i : list){
            System.out.println(i);
            System.out.println(i.getClass());
        }
    }
    @Test
    public void test1(){

    }
}
