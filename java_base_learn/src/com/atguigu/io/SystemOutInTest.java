package com.atguigu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liweiliang
 * @create 2022-11-03 19:57
 * @description 标准输入输出流:System.in:默认从控制台输出
 *                      System.out:默认从控制台输出
 *                      System类的SetIn(InputStream in)/SetOut(PrintStream ps)重新指定输入和输出的流
 */
public class SystemOutInTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("请输入字符串:");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String UpperCase = data.toUpperCase();
                System.out.println(UpperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
