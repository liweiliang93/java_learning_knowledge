package com.atguigu.setcomparetest;

/**
 * @author liweiliang
 * @create 2022-10-18 10:48
 * @description
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate mydate) {
        int minusYear = this.getYear() - mydate.getYear();
        if (minusYear != 0) return minusYear;
        int minusMonth = this.getMonth() - mydate.getMonth();
        if (minusMonth != 0) return minusMonth;
        int minusDay = this.getDay() - mydate.getDay();
        return minusDay;
    }

    //按出生年月日排序
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof MyDate) {
//            MyDate mydate = (MyDate) o;
//            int minusYear = this.getYear() - mydate.getYear();
//            if (minusYear != 0) return minusYear;
//            int minusMonth = this.getMonth() - mydate.getMonth();
//            if (minusMonth != 0) return minusMonth;
//            int minusDay = this.getDay() - mydate.getDay();
//            return minusDay;
//        }
//        throw new RuntimeException("传入的数据类型不一致");
//    }
}
