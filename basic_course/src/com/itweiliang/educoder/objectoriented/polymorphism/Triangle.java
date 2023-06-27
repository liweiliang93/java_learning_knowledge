package com.itweiliang.educoder.objectoriented.polymorphism;

import java.util.Scanner;

/**
 * @author liweiliang
 * @create 2023-04-15 00:14:15
 * @description 三角形周长和面积
 */
public class Triangle extends Shape{

    private double length1;
    private double length2;
    private double length3;

    @Override
    public void input(Scanner sc) {
        this.shapeName = "triangle";
        System.out.println("input lengths of three sides:");
        length1=sc.nextDouble();
        length2=sc.nextDouble();
        length3=sc.nextDouble();
    }

    @Override
    public double getPerimeter() {
        return length1+length2+length3;
    }

    @Override
    public double getArea() {
        double s=(length1+length2+length3)/2;
        return Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
    }
}