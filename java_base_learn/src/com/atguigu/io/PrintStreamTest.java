package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-03 20:31
 * @description 打印流:PrintStream 和 PrintWriter
            提供了一系列重载的print()和println()
 */
public class PrintStreamTest {
    @Test
    public void test() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream("E://io.txt"), true)) {
            System.setOut(printStream);
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("刘建辰");
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.close();
    }
    @Test
    public void test2() throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        System.out.println("isMale:" + isMale);
        dis.close();
    }
}
