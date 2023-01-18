package com.atguigu.assemble.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liweiliang
 * @create 2022-10-24 10:54
 * @description
 */
public class CollectionsTest {
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(56);
        list.add(34);
        list.add(0);
        list.add(-97);
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}
