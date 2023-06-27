package com.itweiliang.educoder.networkProgarm.completecommunication;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liweiliang
 * @create 2023-04-09 14:40:06
 * @description
 */
public class Client {
    private Socket socket;
    private OutputStream socketOutputStream;
    private InputStream socketInputStream;
    public void relation() {
        try{
            /********** Begin *********/
            socketInputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = socketInputStream.read(bytes);
            String clientData = new String(bytes,0,len);
            System.out.print("Client has recevied: "+clientData);
            /********** End *********/
            socket.shutdownInput();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        try {
            socket = new Socket("localhost",6000);
            /********** Begin *********/
            socketOutputStream = socket.getOutputStream();
            socketOutputStream.write("I am Client!".getBytes());
            /********** End *********/
            socket.shutdownOutput();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void stop() {
        try {
            socket.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}