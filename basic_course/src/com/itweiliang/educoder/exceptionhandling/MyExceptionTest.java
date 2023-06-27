package com.itweiliang.educoder.exceptionhandling;

import java.util.Scanner;

public class MyExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        int count = 0;
        System.out.println("请输入整数，按q退出：");
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            try {   
                input(num);
                arr[count] = num;
                count++;
            } catch (InputNotValidException e) {
                System.out.println(e.getMessage());
                return;
            }catch (IndexOutOfBoundsException e){
                System.out.println("数组越界");
                return;
            }
        }
        System.out.println("输入的整数如下：");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void input(int num) throws InputNotValidException{
       if (num <= 0 || num >= 100){
           throw new InputNotValidException("输入的数字要大于0小于100!");
       }
    }
}

class InputNotValidException extends Exception{
    public InputNotValidException(String message){
        super(message);
    }
}