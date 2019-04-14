package com.example.pc.evolutiongame;

import com.example.pc.evolutiongame.core.server.AcceptableImpl;
import com.example.pc.evolutiongame.core.client.ClientReceiver;
import com.example.pc.evolutiongame.core.server.ServerConnectingService;
import com.example.pc.evolutiongame.core.server.ServerReceiver;
import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.TcpServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {

    public static TcpServer getServerConfiguration() {
        Gson gson = new GsonBuilder().create();
        return new TcpServer(new ServerReceiver(), new AcceptableImpl(gson), new ServerConnectingService());
    }

    public static TcpClient getClientConfiguration() {
        Gson gson = new GsonBuilder().create();
        return new TcpClient(new ClientReceiver(gson));
    }
}
