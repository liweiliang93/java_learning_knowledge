package com.atguigu.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiliang
 * @create 2022-10-30 10:27
 * @description
 */
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型
    T orderT;
    public Order(){};
    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    public T orderT() {
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    public <E> List<E> getCopyToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e :arr){
            list.add(e);
        }
        return list;
    }
}
