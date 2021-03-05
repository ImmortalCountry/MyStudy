package com.sdy.io.socket;

import com.sdy.io.Model.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: sundy
 * @date: 2021/1/26 11:10
 * @description:
 */
@Slf4j
public class HelloServer {
    public void start(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            Socket socket;
            while ((socket = server.accept()) != null) {
                log.info("client connected");
                try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                    Message message = (Message) ois.readObject();
                    log.info("server receive message:" + message.getContent());
                    message.setContent("new content");
                    oos.writeObject(message);
                    oos.flush();
                } catch (IOException | ClassNotFoundException e) {
                    log.error("occur exception:", e);
                }
            }


        } catch (Exception e) {
            log.error("occur IOException:", e);
        }
    }

    public static void main(String[] args) {
        HelloServer helloServer = new HelloServer();
        helloServer.start(6666);
    }
}
