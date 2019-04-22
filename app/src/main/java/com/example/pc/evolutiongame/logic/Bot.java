package com.example.pc.evolutiongame.logic;

import android.os.Handler;

import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.Player;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.WiFiServiceDiscoveryActivity;
import com.google.gson.Gson;

import static com.example.pc.evolutiongame.core.control.Phase.EVOLUTION;
import static com.example.pc.evolutiongame.core.control.Phase.POWER;

public class Bot implements Player {
    private final Gson gson;
    private final Handler handler;

    public Bot(Gson gson, Handler handler) {
        this.gson = gson;
        this.handler = handler;
    }

    @Override
    public void play(EvolutionContext context, Game game) {
        System.out.println("Bot should turn");
        Room room = game.getRoom();
        com.example.pc.evolutiongame.model.Player currentPlayer = room.getCurrentPlayer();
        if (EVOLUTION == game.getPhase()) {
            int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());
            if (room.getField().getAnimalsCount(currentPlayer) == 0) {
                currentPlayer.playAnimal(room.getField(), localRandomCardNumber);
            } else {
                if (Math.random() * 10 >= 4) {
                    int cardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
                    int animalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));
                    currentPlayer.playProperty(room.getField(), cardNumber, animalNumber, 0);
                } else {
                    currentPlayer.playAnimal(room.getField(), localRandomCardNumber);
                }
            }
            obtainMessage(WiFiServiceDiscoveryActivity.ROOM_READ, room);

            if (!currentPlayer.canPlay()) {
                currentPlayer.setPass(true);
            }

            context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
        }

        if (POWER == game.getPhase()) {
            int animalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

            room.getCurrentPlayer().giveFood(room, animalNumber);

            if (room.getCapacityFood() == 0) {
                room.getCurrentPlayer().setPass(true);
            }

            context.getSender().sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, POWER, room)));
        }

    }

    private void obtainMessage(int what, Object obj) {
        if (handler != null) {
            handler.obtainMessage(what, -1, -1, obj).sendToTarget();
        }
    }
}
