package com.example.pc.evolutiongame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.pc.evolutiongame.core.UiRenderer;
import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.logic.DeckShufler;
import com.example.pc.evolutiongame.model.Animal;
import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Property;
import com.example.pc.evolutiongame.model.Room;

import java.util.ArrayList;
import java.util.List;

import static com.example.pc.evolutiongame.Utils.getNewId;

public class MainBoardActivity extends Activity implements UiRenderer {

    Player player;

    Button hand, reRender;

    Button playerAnimal1, playerAnimal2, playerAnimal3, playerAnimal4, playerAnimal5, playerAnimal6;
    Button enemyAnimal1, enemyAnimal2, enemyAnimal3, enemyAnimal4, enemyAnimal5, enemyAnimal6;

    TableLayout playerTable1, playerTable2, playerTable3, playerTable4, playerTable5, playerTable6;
    ImageView playerImageView_1_1, playerImageView_1_2, playerImageView_1_3, playerImageView_1_4, playerImageView_1_5, playerImageView_1_6;
    ImageView playerImageView_2_1, playerImageView_2_2, playerImageView_2_3, playerImageView_2_4, playerImageView_2_5, playerImageView_2_6;
    ImageView playerImageView_3_1, playerImageView_3_2, playerImageView_3_3, playerImageView_3_4, playerImageView_3_5, playerImageView_3_6;
    ImageView playerImageView_4_1, playerImageView_4_2, playerImageView_4_3, playerImageView_4_4, playerImageView_4_5, playerImageView_4_6;
    ImageView playerImageView_5_1, playerImageView_5_2, playerImageView_5_3, playerImageView_5_4, playerImageView_5_5, playerImageView_5_6;
    ImageView playerImageView_6_1, playerImageView_6_2, playerImageView_6_3, playerImageView_6_4, playerImageView_6_5, playerImageView_6_6;

    TableLayout enemyTable1, enemyTable2, enemyTable3, enemyTable4, enemyTable5, enemyTable6;
    ImageView enemyImageView_1_1, enemyImageView_1_2, enemyImageView_1_3, enemyImageView_1_4, enemyImageView_1_5, enemyImageView_1_6;
    ImageView enemyImageView_2_1, enemyImageView_2_2, enemyImageView_2_3, enemyImageView_2_4, enemyImageView_2_5, enemyImageView_2_6;
    ImageView enemyImageView_3_1, enemyImageView_3_2, enemyImageView_3_3, enemyImageView_3_4, enemyImageView_3_5, enemyImageView_3_6;
    ImageView enemyImageView_4_1, enemyImageView_4_2, enemyImageView_4_3, enemyImageView_4_4, enemyImageView_4_5, enemyImageView_4_6;
    ImageView enemyImageView_5_1, enemyImageView_5_2, enemyImageView_5_3, enemyImageView_5_4, enemyImageView_5_5, enemyImageView_5_6;
    ImageView enemyImageView_6_1, enemyImageView_6_2, enemyImageView_6_3, enemyImageView_6_4, enemyImageView_6_5, enemyImageView_6_6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_board_activity);

        hand = (Button) findViewById(R.id.showDeckButton);
        reRender = (Button) findViewById(R.id.foodCapacityButton);

        playerTable1 = (TableLayout) findViewById(R.id.playerPropertyTable1);
        {
            playerImageView_1_1 = (ImageView) findViewById(R.id.imageView7_1_1);
            playerImageView_1_2 = (ImageView) findViewById(R.id.imageView7_1_2);
            playerImageView_1_3 = (ImageView) findViewById(R.id.imageView7_2_1);
            playerImageView_1_4 = (ImageView) findViewById(R.id.imageView7_2_2);
            playerImageView_1_5 = (ImageView) findViewById(R.id.imageView7_3_1);
            playerImageView_1_6 = (ImageView) findViewById(R.id.imageView7_3_2);
        }
        playerTable2 = (TableLayout) findViewById(R.id.playerPropertyTable2);
        {
            playerImageView_2_1 = (ImageView) findViewById(R.id.imageView8_1_1);
            playerImageView_2_2 = (ImageView) findViewById(R.id.imageView8_1_2);
            playerImageView_2_3 = (ImageView) findViewById(R.id.imageView8_2_1);
            playerImageView_2_4 = (ImageView) findViewById(R.id.imageView8_2_2);
            playerImageView_2_5 = (ImageView) findViewById(R.id.imageView8_3_1);
            playerImageView_2_6 = (ImageView) findViewById(R.id.imageView8_3_2);
        }
        playerTable3 = (TableLayout) findViewById(R.id.playerPropertyTable3);
        {
            playerImageView_3_1 = (ImageView) findViewById(R.id.imageView9_1_1);
            playerImageView_3_2 = (ImageView) findViewById(R.id.imageView9_1_2);
            playerImageView_3_3 = (ImageView) findViewById(R.id.imageView9_2_1);
            playerImageView_3_4 = (ImageView) findViewById(R.id.imageView9_2_2);
            playerImageView_3_5 = (ImageView) findViewById(R.id.imageView9_3_1);
            playerImageView_3_6 = (ImageView) findViewById(R.id.imageView9_3_2);
        }
        playerTable4 = (TableLayout) findViewById(R.id.playerPropertyTable4);
        {
            playerImageView_4_1 = (ImageView) findViewById(R.id.imageView10_1_1);
            playerImageView_4_2 = (ImageView) findViewById(R.id.imageView10_1_2);
            playerImageView_4_3 = (ImageView) findViewById(R.id.imageView10_2_1);
            playerImageView_4_4 = (ImageView) findViewById(R.id.imageView10_2_2);
            playerImageView_4_5 = (ImageView) findViewById(R.id.imageView10_3_1);
            playerImageView_4_6 = (ImageView) findViewById(R.id.imageView10_3_2);
        }
        playerTable5 = (TableLayout) findViewById(R.id.playerPropertyTable5);
        {
            playerImageView_5_1 = (ImageView) findViewById(R.id.imageView11_1_1);
            playerImageView_5_2 = (ImageView) findViewById(R.id.imageView11_1_2);
            playerImageView_5_3 = (ImageView) findViewById(R.id.imageView11_2_1);
            playerImageView_5_4 = (ImageView) findViewById(R.id.imageView11_2_2);
            playerImageView_5_5 = (ImageView) findViewById(R.id.imageView11_3_1);
            playerImageView_5_6 = (ImageView) findViewById(R.id.imageView11_3_2);
        }
        playerTable6 = (TableLayout) findViewById(R.id.playerPropertyTable6);
        {
            playerImageView_6_1 = (ImageView) findViewById(R.id.imageView12_1_1);
            playerImageView_6_2 = (ImageView) findViewById(R.id.imageView12_1_2);
            playerImageView_6_3 = (ImageView) findViewById(R.id.imageView12_2_1);
            playerImageView_6_4 = (ImageView) findViewById(R.id.imageView12_2_2);
            playerImageView_6_5 = (ImageView) findViewById(R.id.imageView12_3_1);
            playerImageView_6_6 = (ImageView) findViewById(R.id.imageView12_3_2);
        }


        enemyTable1 = (TableLayout) findViewById(R.id.enemyPropertyTable1);
        {
            enemyImageView_1_1 = (ImageView) findViewById(R.id.imageView1_1_1);
            enemyImageView_1_2 = (ImageView) findViewById(R.id.imageView1_1_2);
            enemyImageView_1_3 = (ImageView) findViewById(R.id.imageView1_2_1);
            enemyImageView_1_4 = (ImageView) findViewById(R.id.imageView1_2_2);
            enemyImageView_1_5 = (ImageView) findViewById(R.id.imageView1_3_1);
            enemyImageView_1_6 = (ImageView) findViewById(R.id.imageView1_3_2);
        }
        enemyTable2 = (TableLayout) findViewById(R.id.enemyPropertyTable2);
        {
            enemyImageView_2_1 = (ImageView) findViewById(R.id.imageView2_1_1);
            enemyImageView_2_2 = (ImageView) findViewById(R.id.imageView2_1_2);
            enemyImageView_2_3 = (ImageView) findViewById(R.id.imageView2_2_1);
            enemyImageView_2_4 = (ImageView) findViewById(R.id.imageView2_2_2);
            enemyImageView_2_5 = (ImageView) findViewById(R.id.imageView2_3_1);
            enemyImageView_2_6 = (ImageView) findViewById(R.id.imageView2_3_2);
        }
        enemyTable3 = (TableLayout) findViewById(R.id.enemyPropertyTable3);
        {
            enemyImageView_3_1 = (ImageView) findViewById(R.id.imageView3_1_1);
            enemyImageView_3_2 = (ImageView) findViewById(R.id.imageView3_1_2);
            enemyImageView_3_3 = (ImageView) findViewById(R.id.imageView3_2_1);
            enemyImageView_3_4 = (ImageView) findViewById(R.id.imageView3_2_2);
            enemyImageView_3_5 = (ImageView) findViewById(R.id.imageView3_3_1);
            enemyImageView_3_6 = (ImageView) findViewById(R.id.imageView3_3_2);
        }
        enemyTable4 = (TableLayout) findViewById(R.id.enemyPropertyTable4);
        {
            enemyImageView_4_1 = (ImageView) findViewById(R.id.imageView4_1_1);
            enemyImageView_4_2 = (ImageView) findViewById(R.id.imageView4_1_2);
            enemyImageView_4_3 = (ImageView) findViewById(R.id.imageView4_2_1);
            enemyImageView_4_4 = (ImageView) findViewById(R.id.imageView4_2_2);
            enemyImageView_4_5 = (ImageView) findViewById(R.id.imageView4_3_1);
            enemyImageView_4_6 = (ImageView) findViewById(R.id.imageView4_3_2);
        }
        enemyTable5 = (TableLayout) findViewById(R.id.enemyPropertyTable5);
        {
            enemyImageView_5_1 = (ImageView) findViewById(R.id.imageView5_1_1);
            enemyImageView_5_2 = (ImageView) findViewById(R.id.imageView5_1_2);
            enemyImageView_5_3 = (ImageView) findViewById(R.id.imageView5_2_1);
            enemyImageView_5_4 = (ImageView) findViewById(R.id.imageView5_2_2);
            enemyImageView_5_5 = (ImageView) findViewById(R.id.imageView5_3_1);
            enemyImageView_5_6 = (ImageView) findViewById(R.id.imageView5_3_2);
        }
        enemyTable6 = (TableLayout) findViewById(R.id.enemyPropertyTable6);
        {
            enemyImageView_6_1 = (ImageView) findViewById(R.id.imageView6_1_1);
            enemyImageView_6_2 = (ImageView) findViewById(R.id.imageView6_1_2);
            enemyImageView_6_3 = (ImageView) findViewById(R.id.imageView6_2_1);
            enemyImageView_6_4 = (ImageView) findViewById(R.id.imageView6_2_2);
            enemyImageView_6_5 = (ImageView) findViewById(R.id.imageView6_3_1);
            enemyImageView_6_6 = (ImageView) findViewById(R.id.imageView6_3_2);
        }


        playerAnimal1 = (Button) findViewById(R.id.playerMinion1);
        playerAnimal2 = (Button) findViewById(R.id.playerMinion2);
        playerAnimal3 = (Button) findViewById(R.id.playerMinion3);
        playerAnimal4 = (Button) findViewById(R.id.playerMinion4);
        playerAnimal5 = (Button) findViewById(R.id.playerMinion5);
        playerAnimal6 = (Button) findViewById(R.id.playerMinion6);

        enemyAnimal1 = (Button) findViewById(R.id.enemyMinion1);
        enemyAnimal2 = (Button) findViewById(R.id.enemyMinion2);
        enemyAnimal3 = (Button) findViewById(R.id.enemyMinion3);
        enemyAnimal4 = (Button) findViewById(R.id.enemyMinion4);
        enemyAnimal5 = (Button) findViewById(R.id.enemyMinion5);
        enemyAnimal6 = (Button) findViewById(R.id.enemyMinion6);

        final Room room = new Room();

        room.addPlayer(new Player(getNewId()));
        room.addPlayer(new Player(getNewId()));
        room.addDeck(DeckShufler.deckShuffle());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

        for (int i = 0; i < room.numberPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }

        room.setAllNotPass();

        do {
            Player currentPlayer = room.getCurrentPlayer();

            int localRandomCardNumber = (int) (Math.random() * currentPlayer.getCardsCount());

            currentPlayer.playAnimal(room.getField(), localRandomCardNumber);

            if (currentPlayer.getCardsCount() == 0) {
                currentPlayer.setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());

        cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

        for (int i = 0; i < room.numberPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }

        room.setAllNotPass();


        do {
            Player currentPlayer = room.getCurrentPlayer();

            int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
            int localRandomAnimalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

            room.getCurrentPlayer().playProperty(room.getField(), localRandomCardNumber, localRandomAnimalNumber, 0);

            if (room.getCurrentPlayer().getCardsCount() == 0) {
                room.getCurrentPlayer().setPass(true);
            }
            room.setNextPlayer();
        }
        while (!room.allPlayersPass());

        render(room);

        playerAnimal1.setVisibility(View.INVISIBLE);
        playerAnimal2.setVisibility(View.INVISIBLE);
        playerAnimal3.setVisibility(View.INVISIBLE);
        playerAnimal4.setVisibility(View.INVISIBLE);
        playerAnimal5.setVisibility(View.INVISIBLE);
        playerAnimal6.setVisibility(View.INVISIBLE);

        enemyAnimal1.setVisibility(View.INVISIBLE);
        enemyAnimal2.setVisibility(View.INVISIBLE);
        enemyAnimal3.setVisibility(View.INVISIBLE);
        enemyAnimal4.setVisibility(View.INVISIBLE);
        enemyAnimal5.setVisibility(View.INVISIBLE);
        enemyAnimal6.setVisibility(View.INVISIBLE);

        hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();
            }
        });

        reRender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

                for (int i = 0; i < room.numberPlayers(); i++) {
                    room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
                }

                room.setAllNotPass();


                do {
                    Player currentPlayer = room.getCurrentPlayer();

                    int localRandomCardNumber = (int) (Math.random() * room.getCurrentPlayer().getCardsCount());
                    int localRandomAnimalNumber = (int) (Math.random() * room.getCurrentPlayerAnimalsCount(room.getCurrentPlayer()));

                    room.getCurrentPlayer().playProperty(room.getField(), localRandomCardNumber, localRandomAnimalNumber, 0);

                    if (room.getCurrentPlayer().getCardsCount() == 0) {
                        room.getCurrentPlayer().setPass(true);
                    }
                    room.setNextPlayer();
                }
                while (!room.allPlayersPass());

                render(room);

                playerAnimal1.setVisibility(View.INVISIBLE);
                playerAnimal2.setVisibility(View.INVISIBLE);
                playerAnimal3.setVisibility(View.INVISIBLE);
                playerAnimal4.setVisibility(View.INVISIBLE);
                playerAnimal5.setVisibility(View.INVISIBLE);
                playerAnimal6.setVisibility(View.INVISIBLE);

                enemyAnimal1.setVisibility(View.INVISIBLE);
                enemyAnimal2.setVisibility(View.INVISIBLE);
                enemyAnimal3.setVisibility(View.INVISIBLE);
                enemyAnimal4.setVisibility(View.INVISIBLE);
                enemyAnimal5.setVisibility(View.INVISIBLE);
                enemyAnimal6.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void renderAnimals(Room room) {
        List<List<Animal>> playerAnimalList = new ArrayList<>();
        for (int i = 0; i < room.numberPlayers(); i++) {
            playerAnimalList.add(room.getField().getAnimals(room.getPlayers().get(i)));
        }
        if (room.getPlayers().get(0) == player) {
            switch (playerAnimalList.get(0).size()) {
                case 0: {
                    playerAnimal1.setVisibility(View.INVISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 1: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 2: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 3: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 4: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 5: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 6: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.VISIBLE);
                    break;
                }
            }
            switch (playerAnimalList.get(1).size()) {
                case 0: {
                    enemyAnimal1.setVisibility(View.INVISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 1: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 2: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 3: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 4: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 5: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 6: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.VISIBLE);
                    break;
                }
            }
        } else {
            switch (playerAnimalList.get(1).size()) {
                case 0: {
                    playerAnimal1.setVisibility(View.INVISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 1: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 2: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 3: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 4: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 5: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 6: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.VISIBLE);
                    break;
                }
            }
            switch (playerAnimalList.get(0).size()) {
                case 0: {
                    enemyAnimal1.setVisibility(View.INVISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 1: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 2: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 3: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 4: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 5: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                    break;
                }
                case 6: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.VISIBLE);
                    break;
                }
            }
        }
    }

    private void renderAnimalPropertes(Room room) {
        List<Animal> animalList = room.getAnimalsList();

        List<Animal> playerAnimals = new ArrayList<>();
        List<Animal> enemyAnimals = new ArrayList<>();

        for (int i = 0; i < room.getAnimalsList().size(); i++) {
            if (room.getPlayers().get(0) == player) {
                if (room.getAnimalsList().get(i).getPlayer() == room.getPlayers().get(0)) {
                    playerAnimals.add(room.getAnimalsList().get(i));
                } else {
                    enemyAnimals.add(room.getAnimalsList().get(i));
                }
            } else {
                if (room.getAnimalsList().get(i).getPlayer() == room.getPlayers().get(0)) {
                    enemyAnimals.add(room.getAnimalsList().get(i));
                } else {
                    playerAnimals.add(room.getAnimalsList().get(i));
                }
            }
        }

        renderPlayerAnimals(playerAnimals);
        renderEnemyAnimals(enemyAnimals);
    }

    private void renderPlayerAnimals(List<Animal> playerAnimals) {
        if (playerAnimals.size() >= 1) {
            renderProps(playerAnimals, playerImageView_1_1, playerImageView_1_2, playerImageView_1_3, playerImageView_1_4, playerImageView_1_5, playerImageView_1_6, 0);
            if (playerAnimals.size() >= 2) {
                renderProps(playerAnimals, playerImageView_2_1, playerImageView_2_2, playerImageView_2_3, playerImageView_2_4, playerImageView_2_5, playerImageView_2_6, 1);
                if (playerAnimals.size() >= 3) {
                    renderProps(playerAnimals, playerImageView_3_1, playerImageView_3_2, playerImageView_3_3, playerImageView_3_4, playerImageView_3_5, playerImageView_3_6, 2);
                    if (playerAnimals.size() >= 4) {
                        renderProps(playerAnimals, playerImageView_4_1, playerImageView_4_2, playerImageView_4_3, playerImageView_4_4, playerImageView_4_5, playerImageView_4_6, 3);
                        if (playerAnimals.size() >= 5) {
                            renderProps(playerAnimals, playerImageView_5_1, playerImageView_5_2, playerImageView_5_3, playerImageView_5_4, playerImageView_5_5, playerImageView_4_6, 4);
                            if (playerAnimals.size() >= 6) {
                                renderProps(playerAnimals, playerImageView_6_1, playerImageView_6_2, playerImageView_6_3, playerImageView_6_4, playerImageView_4_5, playerImageView_6_6, 5);
                            }
                        }
                    }
                }
            }
        }
    }

    private void renderProps(List<Animal> animals, ImageView imageView_1, ImageView imageView_2, ImageView imageView_3, ImageView imageView_4, ImageView imageView_5, ImageView imageView_6, int i) {
        if (animals.get(i).getProperty().size() >= 1) {
            renderProp(animals.get(i).getProperty().get(0), imageView_1);
            if (animals.get(i).getProperty().size() >= 2) {
                renderProp(animals.get(i).getProperty().get(1), imageView_2);
                if (animals.get(i).getProperty().size() >= 3) {
                    renderProp(animals.get(i).getProperty().get(2), imageView_3);
                    if (animals.get(i).getProperty().size() >= 4) {
                        renderProp(animals.get(i).getProperty().get(3), imageView_4);
                        if (animals.get(i).getProperty().size() >= 5) {
                            renderProp(animals.get(i).getProperty().get(4), imageView_5);
                            if (animals.get(i).getProperty().size() >= 6) {
                                renderProp(animals.get(i).getProperty().get(5), imageView_6);
                            }
                        }
                    }
                }
            }
        }
    }

    private void renderEnemyAnimals(List<Animal> enemyAnimals) {
        if (enemyAnimals.size() >= 1) {
            renderProps(enemyAnimals, enemyImageView_1_1, enemyImageView_1_2, enemyImageView_1_3, enemyImageView_1_4, enemyImageView_1_5, enemyImageView_1_6, 0);
            if (enemyAnimals.size() >= 2) {
                renderProps(enemyAnimals, enemyImageView_2_1, enemyImageView_2_2, enemyImageView_2_3, enemyImageView_2_4, enemyImageView_2_5, enemyImageView_2_6, 1);
                if (enemyAnimals.size() >= 3) {
                    renderProps(enemyAnimals, enemyImageView_3_1, enemyImageView_3_2, enemyImageView_3_3, enemyImageView_3_4, enemyImageView_3_5, enemyImageView_3_6, 2);
                    if (enemyAnimals.size() >= 4) {
                        renderProps(enemyAnimals, enemyImageView_4_1, enemyImageView_4_2, enemyImageView_4_3, enemyImageView_4_4, enemyImageView_4_5, enemyImageView_4_6, 3);
                        if (enemyAnimals.size() >= 5) {
                            renderProps(enemyAnimals, enemyImageView_5_1, enemyImageView_5_2, enemyImageView_5_3, enemyImageView_5_4, enemyImageView_5_5, enemyImageView_4_6, 4);
                            if (enemyAnimals.size() >= 6) {
                                renderProps(enemyAnimals, enemyImageView_6_1, enemyImageView_6_2, enemyImageView_6_3, enemyImageView_6_4, enemyImageView_4_5, enemyImageView_6_6, 5);
                            }
                        }
                    }
                }
            }
        }
    }

    private void renderProp(Property property, ImageView imageView) {
        switch (property.getValue()) {
            case BURROWING: {
                imageView.setImageResource(R.drawable.burrowing_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case COMMOUFLAGE: {
                imageView.setImageResource(R.drawable.commouflage_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case CARNIVOROUS: {
                imageView.setImageResource(R.drawable.carnivorous_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case COMMUNICATION: {
                imageView.setImageResource(R.drawable.communication_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case COOPERATION: {
                imageView.setImageResource(R.drawable.cooperation_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case GRAZING: {
                imageView.setImageResource(R.drawable.grazing_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case HIBERNATION_ABILITY: {
                imageView.setImageResource(R.drawable.hibernation_ability_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case HIGH_BODY_WEIGHT: {
                imageView.setImageResource(R.drawable.high_body_weight_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case MIMICRY: {
                imageView.setImageResource(R.drawable.mimicry_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case PARASITE: {
                imageView.setImageResource(R.drawable.parasite_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case PIRACY: {
                imageView.setImageResource(R.drawable.pirasy_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case POISONOUS: {
                imageView.setImageResource(R.drawable.poisonous_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case RUNNING: {
                imageView.setImageResource(R.drawable.running_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case SCAVENGER: {
                imageView.setImageResource(R.drawable.scavenger_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case SHARP_VISION: {
                imageView.setImageResource(R.drawable.sharp_vision_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case SWIMMING: {
                imageView.setImageResource(R.drawable.swimming_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case SYMBIOSYS: {
                imageView.setImageResource(R.drawable.symbiosis_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            case TAIL_LOSS: {
                imageView.setImageResource(R.drawable.tail_loss_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
            default: {
                imageView.setImageResource(R.drawable.evolution_prp);
                System.out.println("" + property + " " + imageView.getId());
                break;
            }
        }
    }

    public void open() {
        Intent intent = new Intent(this, MainHandActivity.class);
        startActivity(intent);
    }

    @Override
    public void render(Room room) {
        renderAnimalPropertes(room);
        renderAnimals(room);
    }
}
