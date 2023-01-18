package com.atguigu.timeapi;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 *  1.System类中currentTimeMillis();
 *  2.java.util.Date和子类java.sql.Date
 *  3.SimpleDateFormat
 *  4.Calendar
 *
 * @author liweiliang
 * @create 2022-10-02 10:45
 */
public class SimpleDateTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
        1.1 格式化：日期------>字符串
        1.2 解析： 格式化的逆过程，字符串----->日期
    2.SimpleDateFormat的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        String time = "22-10-2 上午10:56";
        Date date1 = simpleDateFormat.parse(time);
        System.out.println(date1);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1= simpleDateFormat1.format(date);
        System.out.println(format1);

        Date parse = simpleDateFormat1.parse("2019-12-24 11:23:23");
        System.out.println(parse);
    }
}
