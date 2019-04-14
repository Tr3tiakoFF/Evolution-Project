package com.example.pc.evolutiongame.core.client;

import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Processable;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

import static com.example.pc.evolutiongame.core.control.Action.REFRESH_STATE;
import static com.example.pc.evolutiongame.core.control.Action.SET_ID;
import static com.example.pc.evolutiongame.core.control.Phase.EVOLUTION;
import static com.example.pc.evolutiongame.core.control.Phase.POWER;

public class ClientReceiver implements Processable {

    private final Gson gson;

    public ClientReceiver(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void process(Context context, String msg) {
        System.out.printf("Received message->%s%n", msg);
        if (msg == null) {
            return;
        }
        Game game = gson.fromJson(msg, Game.class);

        if (SET_ID == game.getAction()) {
            String id = game.getPlayer().getId();
            System.out.printf("Set id for client->%s%n", id);
            context.setId(id);
        }

        if (REFRESH_STATE == game.getAction()) {
            Room room = game.getRoom();
            Player currentPlayer = room.getCurrentPlayer();

            if (EVOLUTION == game.getPhase()) {
                System.out.println("Process evolution phase");
                if (context.getId().equals(currentPlayer.getId()) && !currentPlayer.isPass()) {
                    System.out.println("Player should turn");

                    int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());
                    currentPlayer.playAnimal(room.getField(), localRandomCardNumber);

                    if (!currentPlayer.canPlay()) {
                        currentPlayer.setPass(true);
                    }

                    context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
                } else {
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
