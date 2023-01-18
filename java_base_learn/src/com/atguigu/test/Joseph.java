package com.atguigu.test;
import java.util.Scanner;
public class Joseph {

    private static Node head;

    static class Node {
        int number;
        Node next;
    }

    /**
     * 创建循环链表
     * @param n 节点个数
     */
    private static void create(int n) {
        head = new Node();
        head.number = 1;
        Node p = head, q;
        for (int i = 1; i < n; i++) {
            q = new Node();
            q.number = i + 1;
            p.next = q;
            p = q;
        }
        p.next = head;
    }

    /**
     * 开始约瑟夫环淘汰过程
     * @param k 淘汰号
     */
    private static void start(int k) {
        Node node = head;
        int t = 1;
        while (node.next.next != node) {
            while (t < k - 1) {
                node = node.next;
                t++;
            }
            System.out.print( node.next.number+" ");
            node.next = node.next.next;
            node = node.next;
            t = 1;
        }
        System.out.println();
        System.out.print(node.next.number+" "+node.number);
    }

    /**
     * @param total 总人数
     * @param number 淘汰号
     */
    public static void run(int total, int number) {
        if (number <= 1) {
            System.out.println("请输入正确数字（大于1）!");
            return;
        }
        System.out.println("总人数（编号1-5）：" + total + "\t" + "淘汰号：" + number);
        create(total);
        start(number);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int number = 3;
        run(total, number);
    }
}

