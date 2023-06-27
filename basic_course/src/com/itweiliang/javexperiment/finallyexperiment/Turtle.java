package com.itweiliang.javexperiment.finallyexperiment;

/**
 * @author liweiliang
 * @create 2023-04-16 10:28:41
 * @description 使用多线程：乌龟速度为1米/1500毫秒,乌龟不休息一直跑到终点
 */
public class Turtle extends Thread{

    private int total_distance = 800;
    private int current_distance = 0;

    @Override
    public void run() {
        while(current_distance < total_distance){
            try {
                Thread.sleep(1500);
                current_distance += 100;
                if(current_distance != 100 || current_distance != 200){
                    if(current_distance >= 300){
                        System.out.println("乌龟跑了"+current_distance+"米"+",此时兔子在睡觉");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}