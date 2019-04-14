package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.core.server.TcpServer;

import java.net.Socket;

public interface Acceptable {
    void accept(TcpServer server, Socket clientSocket, Context context);
}
