package com.atguigu.timeapi;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liweiliang
 * @description
 * @create 2022-10-05 11:25
 */
public class GoodTest{
    @Test
    public void test() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lianxiangMorse", 34);
        goods[1] = new Goods("dellMouse", 43);
        goods[2] = new Goods("xiaoMiMouse", 45);
        goods[3] = new Goods("huaWeiMouse", 65);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}

