package com.itweiliang.educoder.networkProgarm.serversidelistening;

import java.net.Socket;

/**
 * @author liweiliang
 * @create 2023-04-09 10:18:44
 * @description 创建一个Client类,实现start()和stop()方法
 */
public class Client {
    private Socket socket;
    public void start() {
        try {
            socket = new Socket("localhost",6000);  //创建客户端套接字,向localhost6000端口发起请求
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void stop() {
        try{
            socket.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
