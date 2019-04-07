package com.example.pc.evolutiongame.core;

import java.net.Socket;

class AcceptableImpl implements Acceptable {
    @Override
    public void accept(TcpServer server, Socket clientSocket) {
//        server.sendMsg("hi from server");

        server.sendMsg(clientSocket, "hi from server");
    }
}
