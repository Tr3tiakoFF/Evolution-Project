package com.example.pc.evolutiongame;

import android.os.Handler;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.Player;
import com.example.pc.evolutiongame.core.client.ClientConnector;
import com.example.pc.evolutiongame.core.client.ClientProcessor;
import com.example.pc.evolutiongame.core.client.TcpClient;
import com.example.pc.evolutiongame.core.server.AcceptableImpl;
import com.example.pc.evolutiongame.core.server.ServerReceiver;
import com.example.pc.evolutiongame.core.server.TcpServer;
import com.example.pc.evolutiongame.logic.Bot;
import com.example.pc.evolutiongame.logic.Human;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {

    public static TcpServer getServerConfiguration(Handler handler, String gameMode, Connectable connector) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();
        context.setGameMode(gameMode);

        return new TcpServer(context, new ServerReceiver(gson), new AcceptableImpl(gson), connector);
    }

    public static TcpClient getBotConfiguration(Handler handler) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();
        Player bot = new Bot(gson, handler);

        return new TcpClient(context, new ClientProcessor(gson, handler, bot), new ClientConnector(handler));
    }

    public static TcpClient getHumanConfiguration(Handler handler) {
        Gson gson = new GsonBuilder().create();
        EvolutionContext context = new EvolutionContext();
        Player bot = new Human(gson, handler);

        return new TcpClient(context, new ClientProcessor(gson, handler, bot), new ClientConnector(handler));
    }
}
