package com.itweiliang.educoder.networkProgarm.serversidelistening;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liweiliang
 * @create 2023-04-09 10:19:39
 * @description 创建一个Server类,实现start方法,
 */
public class Server {
    public ServerSocket serverSocket;
    public Socket socket;

    public void start() {
        try {
            Client client = new Client();
            /********** Begin *********/
            serverSocket = new ServerSocket(6000);
            client.start();    //启动客户端
            socket = serverSocket.accept();
            serverSocket.close();
            socket.close();
            /********** End *********/
            client.stop();    //关闭客户端
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}