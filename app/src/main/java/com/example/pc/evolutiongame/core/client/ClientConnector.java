package com.example.pc.evolutiongame.core.client;

import android.os.Handler;

import com.example.pc.evolutiongame.core.Connectable;
import com.example.pc.evolutiongame.core.EvolutionContext;

public class ClientConnector implements Connectable {

    private final Handler handler;

    public ClientConnector(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void started(EvolutionContext context) {
        System.out.println("Client is started");
    }
}