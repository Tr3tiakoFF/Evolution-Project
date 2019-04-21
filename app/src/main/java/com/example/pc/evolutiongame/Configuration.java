package com.example.pc.evolutiongame;

import android.os.Handler;

import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.client.ClientConnector;
import com.example.pc.evolutiongame.core.client.ClientReceiver;
import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.AcceptableImpl;
import com.example.pc.evolutiongame.core.server.ServerConnector;
import com.example.pc.evolutiongame.core.server.ServerReceiver;
import com.example.pc.evolutiongame.core.server.TcpServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {

    public static TcpServer getServerConfiguration() {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();

        return new TcpServer(context, new ServerReceiver(gson), new AcceptableImpl(gson), new ServerConnector());
    }

    public static TcpClient getClientConfiguration(Handler handler) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();

        return new TcpClient(context, new ClientReceiver(gson, handler), new ClientConnector(handler));
    }
}
