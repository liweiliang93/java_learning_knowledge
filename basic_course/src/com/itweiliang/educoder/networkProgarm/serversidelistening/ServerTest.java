package com.itweiliang.educoder.networkProgarm.serversidelistening;

/**
 * @author liweiliang
 * @create 2023-04-09 10:20:31
 * @description
 */
public class ServerTest {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        if (server.socket.isBound()) {
            System.out.print("connected!");
        }
    }
}