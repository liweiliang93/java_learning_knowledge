package com.itweiliang.educoder.objectoriented.polymorphism;

import java.util.Scanner;

/**
 * @author liweiliang
 * @create 2023-04-15 00:13:53
 * @description
 */
public class Rectangle extends Shape{

    private double length;
    private double width;
    @Override
    public void input(Scanner sc) {
        this.shapeName = "rectangle";
        System.out.println("input width and height:");
        length=sc.nextDouble();
        width=sc.nextDouble();
    }

    @Override
    public double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public double getArea() {
        return length*width;
    }
}