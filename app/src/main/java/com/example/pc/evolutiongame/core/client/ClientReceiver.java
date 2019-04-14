package com.example.pc.evolutiongame.core.client;

import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Processable;
import com.example.pc.evolutiongame.core.control.Game;
import com.google.gson.Gson;

import static com.example.pc.evolutiongame.core.control.Action.SET_ID;

public class ClientReceiver implements Processable {

    private Gson gson;

    public ClientReceiver(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void process(Context context, String msg) {
        System.out.printf("Received msg->%n%s%n", msg);

        Game game = gson.fromJson(msg, Game.class);

        if (SET_ID == game.getAction()) {
            String id = game.getPlayer().getId();
            System.out.printf("Set id for client->%s%n", id);
            context.setId(id);
        }
    }
}
