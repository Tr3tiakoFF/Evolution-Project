package com.example.pc.evolutiongame.logic;

import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;

import org.junit.Assert;
import org.junit.Test;

public class PlayersRoomJoiningTest {
    @Test
    public void roomJoinedPlayers (){
        Room room = new Room();

        for (int i = 0; i < 4; i++) {
            room.addPlayer(new Player());
        }

        Assert.assertNotNull(room.getPlayers());
        Assert.assertTrue(room.getPlayers().size() >= 2);
        Assert.assertTrue(room.getPlayers().size() <= 6);
    }

    @Test
    public void roomCanJoinedPlayersTest (){
        Room room = new Room();

        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());
        room.addPlayer(new Player());

        Assert.assertTrue(room.canAddPlayer());

        room.addPlayer(new Player());

        Assert.assertFalse(room.canAddPlayer());

        room.addPlayer(new Player());
        room.addPlayer(new Player());

        Assert.assertFalse(room.canAddPlayer());
    }
}
