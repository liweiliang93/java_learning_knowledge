package com.atguigu.ip;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liweiliang
 * @create 2022-11-05 15:41
 * @description
 */
public class TCPTest1 {
    /*
    客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);//指定客户端的ip、端口号
            os = socket.getOutputStream();//输出流
            bufferedInputStream = new BufferedInputStream(new FileInputStream("4.png"));
            byte[] buffer = new byte[10];
            int len;
            while((len = bufferedInputStream.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while((len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    服务端
     */
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket  = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("5.png"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好，美女，照片我已收到，很漂亮".getBytes());
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
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
