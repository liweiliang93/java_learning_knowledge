package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-02 22:42
 * @description
 */
public class PicTest {
    @Test
    public void test(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("4.png"));
            fileOutputStream = new FileOutputStream("5.png");
            byte[] cbuf = new byte[10];
            int len;
            while((len = fileInputStream.read(cbuf)) != -1){
                for(int i = 0;i < len;i++){
                    cbuf[i] = (byte) (cbuf[i] ^ 5);
                }
                fileOutputStream.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("5.png"));
            fileOutputStream = new FileOutputStream("6.png");
            byte[] cbuf = new byte[10];
            int len;
            while((len = fileInputStream.read(cbuf)) != -1){
                for(int i = 0;i < len;i++){
                    cbuf[i] = (byte) (cbuf[i] ^ 5);
                }
                fileOutputStream.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test3() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("4.png")));
           bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("hello1.png")));
            byte[] cbuf = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(cbuf)) != -1) {
                bufferedOutputStream.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
