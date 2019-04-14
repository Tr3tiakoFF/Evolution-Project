package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Acceptable;
import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Sendable;
import com.example.pc.evolutiongame.core.control.Action;
import com.example.pc.evolutiongame.core.control.Game;
import com.example.pc.evolutiongame.core.control.Phase;
import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.logic.DeckShufler;
import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.google.gson.Gson;

import java.net.Socket;
import java.util.List;

import static com.example.pc.evolutiongame.Utils.getNewId;

public class AcceptableImpl implements Acceptable {

    private Gson gson;

    public AcceptableImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void accept(Socket clientSocket, Context context) {
        System.out.printf("Client ->%s connected to server%n", clientSocket.getRemoteSocketAddress());
        Sendable sender = context.getSender();

        Room room = context.getRoom();
        Player player = new Player(getNewId());
        room.addPlayer(player);

        ((TcpServer) sender).sendMessage(clientSocket, gson.toJson(new Game(Action.SET_ID, player)));

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

        sender.sendMessage(gson.toJson(new Game(Action.REFRESH_STATE, Phase.EVOLUTION, room)));
    }
}
