package com.atguigu.generic;

import org.junit.Test;

import java.util.List;

/**
 * @author liweiliang
 * @create 2022-10-30 10:32
 * @description
 */
public class GenerticTest1 {
    @Test
    public void test(){
        //泛型父类的实例化
        Order<Integer> order = new Order();
        order.setOrderT(123);
        Order<String> stringOrder = new Order<>("ordername",1001,"order:AA");
        stringOrder.setOrderT("Order:11");
        //指明泛型的子类的实例化
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(23);
        //泛型子类的实例化
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("SubOrder1:BB");
        //泛型方法的使用
        Order<Integer> order1 = new Order<>();
        Integer[] in1 = new Integer[]{1,2,3,4};
        List<Integer> copyToList = order1.getCopyToList(in1);
        System.out.println(copyToList);
    }
}
