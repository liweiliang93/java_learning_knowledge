package com.itweiliang.educoder.objectoriented.polymorphism;

import java.util.Scanner;

/**
 * @author liweiliang
 * @create 2023-04-15 00:14:00
 * @description
 */
public abstract class Shape{
    public String shapeName;
    public abstract void input(Scanner sc);
    public abstract double getPerimeter();
    public abstract double getArea();
}