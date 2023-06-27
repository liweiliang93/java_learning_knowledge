package com.itweiliang.educoder.networkProgarm.completecommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liweiliang
 * @create 2023-04-09 14:40:27
 * @description
 */
public class Server extends Thread {
    private ServerSocket serverSocket;
    private boolean _run=true;
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void run() {
        while(_run) {
            try {
                Client client = new Client();
                client.start();
                Socket socket = serverSocket.accept();
                System.out.println("connected!");

                InputStream socketInputStream = socket.getInputStream();
                byte[] bytes = new byte[1000];
                int length = socketInputStream.read(bytes);
                String clientData = new String(bytes,0,length);
                System.out.println("Server has received: " + clientData);

                OutputStream socketOutputStream = socket.getOutputStream();
                socketOutputStream.write("I am Server!".getBytes());
                client.relation();

                serverSocket.close();
                socket.close();
                client.stop();
            }
            catch(IOException e) {
                System.out.print("communication is over!");
                break;
            }
            finally {
                this._run=!_run;
            }
        }
    }
    public static void main(String[] args) {
        try {
            Thread thread = new Server(6000);
            thread.start();
        }
        catch(IOException e) {
            System.out.print("done!");
        }
    }
}
