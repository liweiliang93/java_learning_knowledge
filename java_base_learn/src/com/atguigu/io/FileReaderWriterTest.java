package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-01 20:06
 * @description
 */
public class FileReaderWriterTest {

    /*
    将当前hello.txt文件内容读出，并输出到控制台
     */
    @Test
    public void test() {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fileReader != null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() throws IOException {
        File file = null;    //File文件初始化
        FileReader fileReader = null;
        try {
            file = new File("hello.txt");
            fileReader = new FileReader(file);
            char[] cbuf = new char[5];    //定义每次读入几个字符
            int len;                    //返回每次读入字符的个数，当为-1时，即为文件末位
            while ((len = fileReader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);    //从0开始读入到len长度的字符
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();        //如果文件读入流创建成功，最后就关闭流
            }
        }
    }

    /*
        文本文件的复制操作----------->FileWriter、FileReader综合使用
     */
    @Test
    public void test2(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    非文本文件的复制操作----------->FileOutputStream和FileInputStream的综合使用
     */
    @Test
    public void test3(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File("4.png");
            File destFile = new File("5.png");
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            byte[] cbuf = new byte[1024];
            int len;
            while((len = fileInputStream.read(cbuf)) != -1){
                fileOutputStream.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}