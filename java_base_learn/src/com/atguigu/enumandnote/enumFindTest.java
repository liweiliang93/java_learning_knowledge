package com.atguigu.enumandnote;

/**
 * @author liweiliang
 * @create 2022-10-05 16:33
 * @description 使用enum关键字定义的枚举类实现接口的情况
 *          情况一：实现接口，在enum类中实现抽象方法
 *          情况二：让枚举类的对象分别实现抽象方法
 */

public class enumFindTest {
    public static void main(String[] args) {
        Season1[] values = Season1.values();
        for(int i = 0; i < values.length; i++){
            System.out.println(values[i]);
            values[i].show();
        }
    }
}

interface Info{
    void show();
}

enum Season1 implements Info{

    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("相约在冬季");
        }
    };

    private final String SeasonDec;
    private final String SeasonName;
    private Season1(String SeasonName,String SeasonDec){
        this.SeasonDec = SeasonDec;
        this.SeasonName = SeasonName;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}