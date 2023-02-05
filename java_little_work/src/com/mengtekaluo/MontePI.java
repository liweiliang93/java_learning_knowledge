package com.mengtekaluo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Random;

import javax.swing.*;

public class MontePI {
    public static void main(String[] args) {
        // 设置图形化界面的窗体
        JFrame myFrame = new JFrame("MontePI");
        myFrame.setLocation(220, 60); // 设置窗体位置
        myFrame.setSize(1000, 800); // 设置窗体大小
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体可通过点击关闭
        myFrame.setVisible(true); // 设置窗体可见

        // 设置获取的值
        final int[] number = {0};
        // 添加按钮
        myFrame.setLayout(new FlowLayout());
        JButton bt = new JButton("(输入随机数的个数:)Run");
        myFrame.add(bt);
        // 添加文本输入框
        TextField tf = new TextField(30);
        myFrame.add(tf);
        // 添加监视器
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == bt) {
                    // 关闭第一个窗口
                    // 获取输入后的数据并传入Points对象中
                    JFrame frame = new JFrame("MontePI");
                    frame.setLocation(220, 60); // 设置窗体位置
                    frame.setSize(1000, 800); // 设置窗体大小
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体可通过点击关闭
                    frame.setVisible(true); // 设置窗体可见
                    // 添加文字提示信息
                    Points points = new Points(number[0]); // 创建点和坐标系
                    frame.add(points); // 将点添加到窗体内
                }
            }
        });
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();
                System.out.println("当前文本框中的内容为:" + text);
                number[0] = Integer.parseInt(text);
            }
        });
        myFrame.pack();
    }
}

class Points extends JPanel {
    public int number;

    public Points(int num) {
        number = num;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 创建Graphics2D对象,开始进行绘制
        Graphics2D g2d = (Graphics2D)g;

        // 绘制弧形1/4圆
        g2d.setColor(Color.GRAY);
        g2d.fillArc(-100, 300, 600, 600, 0, 90);

        // 绘制坐标轴
        g2d.setColor(Color.black);
        g2d.drawLine(200, 600, 200, 250);
        g2d.drawLine(200, 600, 550, 600);

        g2d.setColor(Color.black);
        g2d.drawLine(200, 300, 500, 300);
        g2d.drawLine(500, 300, 500, 600);
        g2d.drawString("0", 190, 610);
        for (int i = 1; i <= 10; i++) {
            g2d.drawString("0." + i, 200 + i * 30, 610);
        }
        for (int i = 1; i <= 10; i++) {
            g2d.drawString("0." + i, 175, 600 - 30 * i);
        }
        g2d.drawString("使用蒙特卡洛方法生成图", 270, 650);
        // 获取随机点坐标,并分别绘制出来
        int countNumber = 0;
        for (int i = 0; i <= number; i++) {
            Dimension size = getSize();
            int w = size.width;
            int h = size.height;
            Random r = new Random();
            double x1 = Math.random();
            double y1 = Math.random();
            int x = (int)(200 + x1 * 300);
            int y = (int)(600 - y1 * 300);

            // 绘制坐标位于弧形之内的点
            if (x1 * x1 + y1 * y1 <= 1.0) {
                g2d.setColor(Color.red);
                g2d.drawOval(x, y, 1, 1);
                countNumber = countNumber + 1;
            } else {
                g2d.setColor(Color.black);
                g2d.drawOval(x, y, 1, 1);
            }
        }
        // 计算所得的近似值
        double pai = (double)countNumber / number * 4;

        // 在界面上显示所得的近似值
        g2d.setColor(Color.black);
        g2d.drawString("输入的随机数的个数为:" + number + "个", 700, 300);
        g2d.drawString("算得的π的近似值为:" + pai, 700, 400);
    }
}