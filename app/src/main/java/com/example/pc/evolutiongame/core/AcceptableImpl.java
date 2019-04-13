package com.example.pc.evolutiongame.core;

import java.net.Socket;

public class AcceptableImpl implements Acceptable {
    @Override
    public void accept(TcpServer server, Socket clientSocket) {
//        server.sendMsg("hi from server");
        System.out.printf("Client ->%s connected to server ->%s%n", clientSocket.getRemoteSocketAddress(), "");

//        server.sendMsg(clientSocket, "hi from server");
    }
}
