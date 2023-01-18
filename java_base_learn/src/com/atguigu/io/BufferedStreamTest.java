package com.atguigu.io;

import org.junit.Test;

import java.io.*;
/**
 * @author liweiliang
 * @create 2022-11-02 11:35
 * @description 非文本文件通过缓冲流进行文件的复制操作
 */
public class BufferedStreamTest {
    @Test
    public void test() {
        String srcPath = "4.png";
        String destPath = "5.png";
        copyBuffered(srcPath,destPath);
    }
    public void copyBuffered(String srcPath,String destPath) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(srcPath)));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(destPath)));
            //读取和写入的过程
            byte[] buffer = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
