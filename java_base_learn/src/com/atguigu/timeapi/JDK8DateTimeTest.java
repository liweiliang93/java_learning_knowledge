package com.atguigu.timeapi;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author liweiliang
 * @description
 * @create 2022-10-04 10:46
 */
public class JDK8DateTimeTest {
    /**
    * @description:JDK8以后的DateTime类的使用
    * @author: liweiliang
    * @date: 2022/10/4 11:06
    * @param: []
    * @return: void
    * @details: 分别注意LocalDate,LocalTime,LocalDateTime类、方法的使用
    * @reminder: 将of(),getXxx(),withXxx(),plusXxx(),minusXxx()方法熟记于心
    **/
    @Test
    public void test1(){
        LocalDate localdate = LocalDate.now();
        LocalTime localtiem = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localdate);
        System.out.println(localtiem);
        System.out.println(localDateTime);

        //of()
        LocalDateTime locateDateTime1 = LocalDateTime.of(2020, 10, 2, 12, 23);
        System.out.println(locateDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //set()
        //calendar可变性

        //add()
        //体现不可变性withXxxOfXxx()
        LocalDate localDate = localdate.withDayOfMonth(22);
        System.out.println(localdate);
        System.out.println(localDate);
        //plusXxx():增加时间（时分天年）
        LocalDateTime localDateTime1 = localDateTime.plusHours(3);
        System.out.println(localDateTime1);
        //minusXxx():减小时间（时分天年）
        LocalDateTime localDateTime2 = localDateTime1.minusDays(2);
        System.out.println(localDateTime2);
    }
}
