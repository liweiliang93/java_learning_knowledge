package com.atguigu.timeapi;

import org.junit.Test;

/**
 * @author liweiliang
 * @create 2022-10-02 10:24
 */
public class IDEADebug {
    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
