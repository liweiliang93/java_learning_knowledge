package com.atguigu.timeapi;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liweiliang
 * @description
 * @create 2022-10-05 10:58
 */
public class JavaCompareTest {

    /***
    * @description:Comparable接口的使用
    * @author: liweiliang
    * @date: 2022/10/5 10:58
    * @param: []
    * @return: void
    * @details:
    * @reminder:
    **/
    @Test
    public void compareTest(){
        /*
        1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小
        2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
        2.重写compareTo(obj)的规则:
            如果当前对象this大于形参对象obj，则返回正整数
            如果当前对象this小于形参对象obj，则返回负整数
            如果当前对象this等于形参对象obj，则返回零
         */
        String[] str = new String[]{"mm","gg","jj","kk","tt"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }
}