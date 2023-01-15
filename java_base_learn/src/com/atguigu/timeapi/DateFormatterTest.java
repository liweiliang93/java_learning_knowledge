package com.atguigu.timeapi;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author liweiliang
 * @description DateTimeFormatter的实例化(类似于simpleDateFormatter)
 * @create 2022-10-04 16:03
 */
public class DateFormatterTest {
 //DateFormatter的实例化
    @Test
    public void test1() {
    //方式一：预定义的格式标准：
        //预定义
        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //日期 ------>字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = dataTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //字符串------>日期
        LocalDateTime parse = LocalDateTime.parse("2022-10-04T16:09:41.093");//使用LocalDateTime接收
        System.out.println(parse);
        TemporalAccessor temporalAccessor = dataTimeFormatter.parse("2022-10-04T16:09:41.093");
        System.out.println(temporalAccessor);
    //方式二：本地化相关的格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        //格式化
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format1 = dateTimeFormatter1.format(LocalDate.now());
        System.out.println(format1);
    //方式三：自定义的格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2022-10-05 10:32:38");
        System.out.println(parse1);
    }
}
