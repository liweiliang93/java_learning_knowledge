package com.atguigu.timeapi;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author liweiliang
 * @description
 * @create 2022-10-04 15:42
 */
public class instantTest {
    /***
    * @description: Instant的简单应用
    * @author: liweiliang
    * @date: 2022/10/4 15:43
    * @param: []
    * @return: void
    * @details:
    * @reminder:
    **/
    @Test
    public void test1(){
        //now():获取本初子午线的时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //toEpochMilli()获取自1970年1月1日（UTC）的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //通过给定的毫秒数，获取Instant实例 ----->Date类的get()方法
        Instant instant1 = Instant.ofEpochMilli(1664870013643L);
        System.out.println(instant1);

    }
}
