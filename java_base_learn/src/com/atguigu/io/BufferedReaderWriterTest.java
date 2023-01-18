package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-02 22:21
 * @description 使用BufferedWriter和BufferedReader实现文本文件的复制
 */
public class BufferedReaderWriterTest {
    @Test
    public void testBufferedReaderWriter(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //读写操作(方式一：char[]数组)
//            char[] cbuf = new char[5];
//            int len;
//            while((len = bufferedReader.read(cbuf)) != -1){
//                bufferedWriter.write(cbuf,0,len);
//            }
            //方式二：String
            String data;
            while((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data + '\n');//不包含换行符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
