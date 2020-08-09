package com.sdy.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: SunDeYu
 * @date: 2020/8/9 13:14
 * @description:
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            while (true){
                System.out.println("等待客户端请求");
                socket = server.accept();
                System.out.println("处理客户端请求");
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null){
                server.close();
                System.out.println("The time server close");
                server = null;
            }
        }
    }
}
