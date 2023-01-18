package com.atguigu.reflection.java1;

import java.io.Serializable;

/**
 * @author liweiliang
 * @create 2022-11-20 21:48
 * @description
 */
public class Creature<T> implements Serializable {
    private int gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃饭");
    }
}
