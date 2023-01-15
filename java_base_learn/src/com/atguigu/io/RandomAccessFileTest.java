package com.atguigu.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author liweiliang
 * @create 2022-11-03 23:35
 * @description
 */
public class RandomAccessFileTest {
    /**
     * 随机存取流实现文件的复制操作
     * @throws FileNotFoundException
     */
    @Test
    public void test() throws FileNotFoundException {
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile1 = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("hello.txt"),"r");
            randomAccessFile1 = new RandomAccessFile(new File("hello1.txt"),"rw");
            byte[] buffer = new byte[1024];
            int len;
            while((len = randomAccessFile.read(buffer)) != -1){
                randomAccessFile1.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从指针4开始覆盖操作
     */
    @Test
    public void test2(){
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("hello.txt"),"rw");
            randomAccessFile.seek(4);
            randomAccessFile.write("caonimade".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用RandomAccessFile实现数据的插入操作
     * @throws FileNotFoundException
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("hello.txt","rw");
            randomAccessFile.seek(3);
            StringBuilder stringBuilder = new StringBuilder((int)new File("hello.txt").length());
            byte[] buffer = new byte[10];
            int len;
            while((len = randomAccessFile.read(buffer)) != -1){
                stringBuilder.append(new String(buffer,0,len));
            }
            randomAccessFile.seek(3);
            randomAccessFile.write("xyz".getBytes());
            randomAccessFile.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }
}
