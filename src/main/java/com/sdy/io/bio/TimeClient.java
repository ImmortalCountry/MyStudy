package com.sdy.io.bio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: SunDeYu
 * @date: 2020/8/9 13:57
 * @description:
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out !=null){
                out.close();
                out = null;
            }
            if (in != null){
                try{
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket !=null){
                try{
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }

        }
    }
}
