package com.example.pc.evolutiongame.core;

import java.net.Socket;

public interface Acceptable {
    void accept(TcpServer server, Socket clientSocket, Context context);
}
