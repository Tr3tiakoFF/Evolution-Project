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
import static com.example.pc.evolutiongame.core.control.Phase.EVOLUTION;
import static com.example.pc.evolutiongame.core.control.Phase.POWER;

public class ClientReceiver implements Processor {

    private final Gson gson;
    private final Handler handler;

    public ClientReceiver(Gson gson, Handler handler) {
        this.gson = gson;
        this.handler = handler;
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
            handler.obtainMessage(WiFiServiceDiscoveryActivity.SET_ID, -1, -1, id).sendToTarget();
        }

        if (REFRESH_STATE == game.getAction()) {
            Room room = game.getRoom();

            if (handler != null) {
                handler.obtainMessage(WiFiServiceDiscoveryActivity.ROOM_READ, -1, -1, room).sendToTarget();
            }

            Player currentPlayer = room.getCurrentPlayer();

            if (EVOLUTION == game.getPhase()) {
                System.out.println("Process evolution phase");
                if (context.getId().equals(currentPlayer.getId()) && !currentPlayer.isPass() && currentPlayer.canPlay()) {
                    System.out.println("Player should turn");

                    int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());
                    currentPlayer.playAnimal(room.getField(), localRandomCardNumber);

                    if (!currentPlayer.canPlay()) {
                        currentPlayer.setPass(true);
                    }

                    context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
                } else {

                    if (!currentPlayer.canPlay()) {
                        currentPlayer.setPass(true);
                        context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
                    }

                    System.out.println("Player skip message and waiting turn");
                }
            }

            if (POWER == game.getPhase()) {
                System.out.println("Process power phase");
                if (context.getId().equals(currentPlayer.getId()) && !currentPlayer.isPass()) {
                    System.out.println("Player should turn");

                    room.getCurrentPlayer().giveFood(room, 0);

                    if (room.getCapacityFood() == 0) {
                        room.getCurrentPlayer().setPass(true);
                    }

                    context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, POWER, room)));
                } else {
                    System.out.println("Player skip message and waiting turn");
                }
            }
        }
    }
}
