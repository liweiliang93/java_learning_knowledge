package com.atguigu.timeapi;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liweiliang
 * @description
 * @create 2022-10-04 9:44
 */
public class Calendartest {

    /**
    * @description:Calendar类的实例化和常用方法
    * @author: liweiliang
    * @date: 2022/10/4 9:58
    * @param: []
    * @return: void
    * @details: 掌握Calendar类的实例化及常用方法
    **/
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类的对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        int i1 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(i);
        System.out.println(i1);
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,2);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);
        //setTime()
        Date date = new Date();
        calendar.setTime(date);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

    }
}