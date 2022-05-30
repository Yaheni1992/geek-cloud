package com.geekbrains.cloud;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Сервер запустился");
            while (true) {
                Socket socket = server.accept();
                ChatHandler handler = new ChatHandler(socket);
                new Thread(handler).start();
            }
        }

    }
}