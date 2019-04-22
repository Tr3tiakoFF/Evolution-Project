package com.example.pc.evolutiongame.core.client;

import android.os.Handler;

import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.Processor;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;
import com.google.gson.Gson;

import static com.example.pc.evolutiongame.core.control.Action.REFRESH_STATE;
import static com.example.pc.evolutiongame.core.control.Action.SET_ID;
import static com.example.pc.evolutiongame.core.control.Phase.ENDGAME;
import static com.example.pc.evolutiongame.core.control.Phase.EVOLUTION;
import static com.example.pc.evolutiongame.core.control.Phase.POWER;
import static java.lang.Thread.sleep;

public class ClientProcessor implements Processor {

    private final Gson gson;
    private final Handler handler;
    private final com.example.pc.evolutiongame.core.Player player;

    public ClientProcessor(Gson gson, Handler handler, com.example.pc.evolutiongame.core.Player player) {
        this.gson = gson;
        this.handler = handler;
        this.player = player;
    }

    @Override
    public void process(EvolutionContext context, String msg) {
        System.out.printf("Received message->%s%n", msg);
        if (msg == null) {
            return;
        }

        Game game = gson.fromJson(msg, Game.class);

        if (SET_ID == game.getAction()) {
            String id = game.getPlayer().getId();
            System.out.printf("Set id for client->%s%n", id);
            context.setId(id);
            obtainMessage(WiFiServiceDiscoveryActivity.SET_ID, id);
            return;
        }

        if (REFRESH_STATE != game.getAction()) {
            return;
        }

        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Room room = game.getRoom();
        Player currentPlayer = room.getCurrentPlayer();

        if (ENDGAME == game.getPhase()) {
            obtainMessage(WiFiServiceDiscoveryActivity.ENDGAME, room);
            return;
        }

        obtainMessage(WiFiServiceDiscoveryActivity.ROOM_READ, room);

        if (EVOLUTION == game.getPhase()) {
            room = gson.fromJson(msg, Game.class).getRoom();
            currentPlayer = room.getCurrentPlayer();

            System.out.println("Process evolution phase");
            if (context.getId().equals(currentPlayer.getId()) && !currentPlayer.isPass() && currentPlayer.canPlay()) {
                System.out.println("Player should turn");
                player.play(context, game);
                return;
            }

            if (!currentPlayer.canPlay()) {
                currentPlayer.setPass(true);
                context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
            }

            System.out.println("Player skip message and waiting turn");
        }

        if (POWER == game.getPhase()) {
            System.out.println("Process power phase");
            if (context.getId().equals(currentPlayer.getId()) && !currentPlayer.isPass()) {
                System.out.println("Player should turn");
                player.play(context, game);
                return;
            }
            System.out.println("Player skip message and waiting turn");
        }

        obtainMessage(WiFiServiceDiscoveryActivity.ROOM_READ, room);
    }

    private void obtainMessage(int what, Object obj) {
        if (handler != null) {
            handler.obtainMessage(what, -1, -1, obj).sendToTarget();
        }
    }
}
