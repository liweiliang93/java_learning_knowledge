package com.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author liweiliang
 * @create 2022-11-03 22:36
 * @description
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream来实现
     */
    @Test
    public void testObjectInputOutputStream(){
        ObjectOutputStream objectOutPutStream = null;
        try {
            objectOutPutStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutPutStream.writeObject(new String("我爱北京天安门"));
            objectOutPutStream.flush();
            objectOutPutStream.writeObject(new Person(23,"Tom"));
            objectOutPutStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutPutStream != null) {
                    objectOutPutStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     反序列化：将磁盘文件中的一个对象还原为内存中的一个java对象
     使用ObjectInputStream来实现
     */
    @Test
    public void test1(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = objectInputStream.readObject();
            String str = (String)obj;
            System.out.println(str);
            Object obj1 = objectInputStream.readObject();
            Person str1 = (Person)obj1;
            System.out.println(str1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
