package com.itweiliang.educoder.gui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liweiliang
 * @create 2023-04-09 15:35:53
 * @description
 */
public class ToolUtil {
    public static boolean isEmpty(String str){
        return str == null || "".equals(str.trim());
    }
    public static long getTime(){
        long time = System.currentTimeMillis();
        return time;
    }
    public static String getDateByTime(long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(new Date(time));
        return str;
    }
}