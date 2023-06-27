package com.itweiliang.javexperiment.finallyexperiment;

/**
 * @author liweiliang
 * @create 2023-04-16 10:29:00
 * @description 测试800米龟兔赛跑
 */
public class ThreadTest {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Turtle turtle = new Turtle();
        rabbit.start();
        turtle.start();
    }
}