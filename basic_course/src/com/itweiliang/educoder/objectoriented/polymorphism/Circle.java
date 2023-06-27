package com.itweiliang.educoder.objectoriented.polymorphism;

import java.util.Scanner;

/**
 * @author liweiliang
 * @create 2023-04-15 00:13:23
 * @description
 */
public class Circle extends Shape{
    private double radius;
    public Circle(){
        super();
    }
    public Circle(double radius){
        super();
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void input(Scanner sc) {
        this.shapeName = "circle";
        System.out.println("input radius:");
        radius=sc.nextDouble();
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}