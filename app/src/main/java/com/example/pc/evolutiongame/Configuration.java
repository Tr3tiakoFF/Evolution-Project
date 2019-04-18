package com.example.pc.evolutiongame;

import com.example.pc.evolutiongame.core.EvolutionContext;
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
        EvolutionContext evolutionContext = new EvolutionContext();

        return new TcpServer(evolutionContext, new ServerReceiver(gson), new AcceptableImpl(gson), new ServerConnector());
    }

    public static TcpClient getClientConfiguration(MainBoardActivity mainBoardActivity) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext evolutionContext = new EvolutionContext();

        return new TcpClient(evolutionContext, new ClientReceiver(mainBoardActivity, gson));
    }
}
