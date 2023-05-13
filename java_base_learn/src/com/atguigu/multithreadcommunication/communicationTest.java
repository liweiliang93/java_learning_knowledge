package com.atguigu.multithreadcommunication;
/**
 * @author liweiliang
 * @create 2022-10-05 18:32
 * @description
 *      产品作为静态常量,可供生产者、消费者共同操作
 *      Clerk类作为员工类,通过他进行产品的生产和消费,包含两个方法
 *      Producer类:生产产品,继承Thread类,重写run方法
 *      Consumer类:消费产品,继承Thread类,重写run方法
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
    private static int productNumber = 0;
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
    private final Clerk clerk;
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
    private final Clerk clerk;
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