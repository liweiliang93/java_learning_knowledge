package com.atguigu.multithreadcommunication;
/**
 * @author liweiliang
 * @create 2022-10-05 18:32
 * @description
 */
public class communicationTest{
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Consumer consumer1 = new Consumer(clerk);
        producer.start();
        consumer.start();
        consumer1.start();
    }
}

class Clerk{
    private int productNumber = 0;
    public Clerk(){};
    public synchronized void productProduce(){
        if(productNumber < 20){
            productNumber++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productNumber + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void productConsume(){
        if(productNumber > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productNumber + "个产品");
            productNumber--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("开始生产产品.......");
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productProduce();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("开始消费产品......");
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productConsume();
        }
    }
}