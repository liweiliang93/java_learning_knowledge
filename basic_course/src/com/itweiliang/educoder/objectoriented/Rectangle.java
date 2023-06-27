package com.itweiliang.educoder.objectoriented;

import java.util.Scanner;

/**
 * 矩形类：内置属性长、宽和面积的计算
 */
public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return this.width * this.length;
    }
}

class Rectangular extends Rectangle {
    private double height;

    public Rectangular(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        double Area = getArea();
        return Area * height;
    }

}

class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请分别输入长方体的长宽高:");
        double length = scan.nextDouble();
        double width = scan.nextDouble();
        double height = scan.nextDouble();
        Rectangular rectangular = new Rectangular(length, width, height);
        double volume = rectangular.getVolume();
        System.out.println("-----------------------------------");
        System.out.println("长为"+rectangular.getLength()+",宽为"+rectangular.getWidth()+
                ",高为"+rectangular.getHeight() +"的长方体的体积为:  " + volume);
        System.out.println("-----------------------------------");
    }
}