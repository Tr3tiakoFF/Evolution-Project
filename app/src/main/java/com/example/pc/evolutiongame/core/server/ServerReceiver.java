package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.EvolutionContext;
import com.example.pc.evolutiongame.core.Processor;
import com.example.pc.evolutiongame.core.Sendable;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.core.control.Phase;
import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

import java.util.List;

import static com.example.pc.evolutiongame.core.control.Action.REFRESH_STATE;
import static com.example.pc.evolutiongame.core.control.Phase.EVOLUTION;
import static com.example.pc.evolutiongame.core.control.Phase.POWER;

public class ServerReceiver implements Processor {

    private final Gson gson;

    public ServerReceiver(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void process(EvolutionContext evolutionContext, String msg) {
        System.out.printf("Received msg->%s%n", msg);
        if (msg == null) {
            return;
        }
        Game game = gson.fromJson(msg, Game.class);

        if (REFRESH_STATE == game.getAction()) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Room room = game.getRoom();
            evolutionContext.setRoom(room);

            Sendable sender = evolutionContext.getSender();
            if (EVOLUTION == game.getPhase()) {
                System.out.println("Process evolution phase");
                if (room.allPlayersPass()) {
                    System.out.println("Evolution phase is completed");
                    System.out.printf("All animals->%s%n", room.getAnimals());

                    System.out.println("Start power phase");
                    room.setAllNotPass();
                    room.setCapacityFood(room.numberPlayers());

                    sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, POWER, room)));

                    return;
                }

                room.setNextPlayer();

                room.calculateAnimalsFoodCapacity();

                sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, EVOLUTION, room)));
            }

            if (POWER == game.getPhase()) {
                System.out.println("Process power phase");
                if (room.allPlayersPass()) {
                    System.out.println("Power phase is completed");
                    System.out.printf("All animals->%s%n", room.getAnimals());

                    System.out.println("Start extinction phase");
                    room.getField().killAllMustDie();
                    System.out.println("Extinction phase is completed");

                    if (room.getDeck().isEmpty()) {
                        System.out.printf("Room get winner->%s%n", room.getWinnerId());

                        sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, Phase.ENDGAME, room)));
                        return;
                    }

                    System.out.println("Start evolution phase");

                    room.setAllNotPass();
                    List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());
                    for (int i = 0; i < room.numberPlayers(); i++) {
                        room.addCardsToPlayer(i, cardsForPlayers.get(i));
                    }

                    sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, Phase.EVOLUTION, room)));

                    return;
                }

                room.setNextPlayer();

                sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, POWER, room)));
            }
        }

    }
}
