package com.example.pc.evolutiongame.core;

import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.logic.DeckShufler;
import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

import java.net.Socket;
import java.util.List;

public class AcceptableImpl implements Acceptable {

    private Gson gson;

    public AcceptableImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void accept(TcpServer server, Socket clientSocket, Context context) {
        System.out.printf("Client ->%s connected to server%n", clientSocket.getRemoteSocketAddress());

        Room room = context.getRoom();
        room.addPlayer(new Player());

        if (!room.canStartGame()) {
            System.out.printf("There are number of players->%d. Waiting more players%n", room.numberPlayers());
            return;
        }

        System.out.printf("There are number of players->%d. Game can be started.%n", room.numberPlayers());
        room.addDeck(DeckShufler.deckShuffle());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());
        for (int i = 0; i < room.numberPlayers(); i++) {
            room.addCardsToPlayer(i, cardsForPlayers.get(i));
        }

        String roomAsJson = gson.toJson(room);
        System.out.printf("Room to send to clients->%s%n", roomAsJson);

        server.sendMsg(roomAsJson);
    }
}
