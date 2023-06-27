package com.itweiliang.educoder.objectoriented.polymorphism;

import java.util.Scanner;

/**
 * @author liweiliang
 * @create 2023-04-15 00:13:33
 * @description
 */
public class MainClass {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("welcome to using the tool!");
        while(true) {
            int curChoice = MainClass.showAndSelectChoice();
            Shape shape = null;
            if(curChoice==0) {
                break;
            }
            switch(curChoice) {
                case 1:
                    shape=new Circle();break;
                case 2:
                    shape=new Triangle();break;
                case 3:
                    shape=new Rectangle();break;
                default:
                    System.out.println("error choice!");
                    continue;
            }
            shape.input(sc);
            double perimeter=shape.getPerimeter();
            double area=shape.getArea();
            System.out.printf("perimeter and area of this %s is %.2f, %.2f\n"
                    ,shape.shapeName,perimeter,area);
        }
        sc.close();

    }
    private static int showAndSelectChoice() {
        System.out.println("Please select one of the following options:");
        System.out.println("[0]quit");
        System.out.println("[1]compute perimeter and area of a circle");
        System.out.println("[2]compute perimeter and area of a triangle");
        System.out.println("[3]compute perimeter and area of a rectangle");
        int res=sc.nextInt();

        return res;
    }

}