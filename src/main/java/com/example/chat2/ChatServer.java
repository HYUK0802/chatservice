package com.example.chat2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        List<ChatThread> list = Collections.synchronizedList(new ArrayList<>());// 동시에 접속 안되게 하기위해
        while (true) {
            Socket socket = serverSocket.accept(); // 클라이어트가 접속한다.
            ChatThread chatClient = new ChatThread(socket, list);
            chatClient.start();
        } // while
    }// main
}


