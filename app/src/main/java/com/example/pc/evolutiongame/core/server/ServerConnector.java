package com.example.pc.evolutiongame.core.server;

import android.os.Handler;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.model.Room;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;

public class ServerConnector implements Connectable {

    private static final int NUMBER_PLAYER = 2;
    private Handler handler;

    public ServerConnector(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Server is started");

        context.setRoom(new Room(NUMBER_PLAYER));

        getClientConfiguration(handler).start(context.getAddress().getHostAddress(), context.getPort());
    }
}
