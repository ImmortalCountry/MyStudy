package com.sdy.io.socket;

import com.sdy.io.Model.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: sundy
 * @date: 2021/1/26 11:10
 * @description:
 */
@Slf4j
public class HelloClient {
    public Object send(Message message, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (Exception e) {
            log.error("occur exception:", e);
        }
        return null;
    }

    public static void main(String[] args) {
        HelloClient helloClient = new HelloClient();
        Message content = (Message)helloClient.send(new Message("content from client"), "127.0.0.1", 6666);
        System.out.println(content.getContent());
    }
}
