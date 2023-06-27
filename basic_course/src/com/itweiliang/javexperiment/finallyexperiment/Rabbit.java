package com.itweiliang.javexperiment.finallyexperiment;

/**
 * @author liweiliang
 * @create 2023-04-16 10:28:16
 * @description 使用多线程:兔子速度为5米/500毫秒,等兔子跑到第700米的时候选择休息10000毫秒
 */
public class Rabbit extends Thread{

    private int total_distance = 800;
    private int current_distance = 0;
    private int turtle_Current_Distance = 0;

    @Override
    public void run() {
        //计算每20个500毫秒输出一次兔子的距离,并输出
        while(current_distance < total_distance){
            if(current_distance == 700){
                try {
                    System.out.println("兔子觉得自己怎么能可以赢得比赛，所以选择睡一会");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("乌龟赢得了比赛,此时兔子跑了"+current_distance+"米");
                break;
            }else{
                try {
                    Thread.sleep(500);
                    current_distance += 100;
                    System.out.println("兔子跑了"+current_distance+"米"+"，乌龟跑了"+turtle_Current_Distance+"米");
                    if(current_distance == 100 || current_distance == 400){
                        turtle_Current_Distance += 100;
                        System.out.println("乌龟跑了"+turtle_Current_Distance+"米"+"，此时兔子跑了"+current_distance+"米");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}