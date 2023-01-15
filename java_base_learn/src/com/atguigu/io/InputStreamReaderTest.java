package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-02 23:38
 * @description
 */
public class InputStreamReaderTest {
    @Test
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("hello1.txt");
        //根据文件保存使得字符集，选择相应的字符集
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");//使用系统默认字符集utf-8
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");
        char[] cbuf = new char[1024];
        int len;
        while((len = inputStreamReader.read(cbuf)) != -1){
            outputStreamWriter.write(cbuf,0,len);
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
