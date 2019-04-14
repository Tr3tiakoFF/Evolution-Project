package com.example.pc.evolutiongame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.pc.evolutiongame.model.Animal;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Property;
import com.example.pc.evolutiongame.model.Room;

import java.util.ArrayList;
import java.util.List;

public class MainBoardActivity extends Activity {

    Room room = new Room(2);

    Boolean isServer = true;

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

        playerTable1 = (TableLayout) findViewById(R.id.playerPropertyTable1);
        {
            playerImageView_1_1 = (ImageView) findViewById(R.id.imageView1_1_1);
            playerImageView_1_2 = (ImageView) findViewById(R.id.imageView1_1_2);
            playerImageView_1_3 = (ImageView) findViewById(R.id.imageView1_2_1);
            playerImageView_1_4 = (ImageView) findViewById(R.id.imageView1_2_2);
            playerImageView_1_5 = (ImageView) findViewById(R.id.imageView1_3_1);
            playerImageView_1_6 = (ImageView) findViewById(R.id.imageView1_3_2);
        }
        playerTable2 = (TableLayout) findViewById(R.id.playerPropertyTable2);
        {
            playerImageView_2_1 = (ImageView) findViewById(R.id.imageView2_1_1);
            playerImageView_2_2 = (ImageView) findViewById(R.id.imageView2_1_2);
            playerImageView_2_3 = (ImageView) findViewById(R.id.imageView2_2_1);
            playerImageView_2_4 = (ImageView) findViewById(R.id.imageView2_2_2);
            playerImageView_2_5 = (ImageView) findViewById(R.id.imageView2_3_1);
            playerImageView_2_6 = (ImageView) findViewById(R.id.imageView2_3_2);
        }
        playerTable3 = (TableLayout) findViewById(R.id.playerPropertyTable3);
        {
            playerImageView_3_1 = (ImageView) findViewById(R.id.imageView3_1_1);
            playerImageView_3_2 = (ImageView) findViewById(R.id.imageView3_1_2);
            playerImageView_3_3 = (ImageView) findViewById(R.id.imageView3_2_1);
            playerImageView_3_4 = (ImageView) findViewById(R.id.imageView3_2_2);
            playerImageView_3_5 = (ImageView) findViewById(R.id.imageView3_3_1);
            playerImageView_3_6 = (ImageView) findViewById(R.id.imageView3_3_2);
        }
        playerTable4 = (TableLayout) findViewById(R.id.playerPropertyTable4);
        {
            playerImageView_4_1 = (ImageView) findViewById(R.id.imageView4_1_1);
            playerImageView_4_2 = (ImageView) findViewById(R.id.imageView4_1_2);
            playerImageView_4_3 = (ImageView) findViewById(R.id.imageView4_2_1);
            playerImageView_4_4 = (ImageView) findViewById(R.id.imageView4_2_2);
            playerImageView_4_5 = (ImageView) findViewById(R.id.imageView4_3_1);
            playerImageView_4_6 = (ImageView) findViewById(R.id.imageView4_3_2);
        }
        playerTable5 = (TableLayout) findViewById(R.id.playerPropertyTable5);
        {
            playerImageView_5_1 = (ImageView) findViewById(R.id.imageView5_1_1);
            playerImageView_5_2 = (ImageView) findViewById(R.id.imageView5_1_2);
            playerImageView_5_3 = (ImageView) findViewById(R.id.imageView5_2_1);
            playerImageView_5_4 = (ImageView) findViewById(R.id.imageView5_2_2);
            playerImageView_5_5 = (ImageView) findViewById(R.id.imageView5_3_1);
            playerImageView_5_6 = (ImageView) findViewById(R.id.imageView5_3_2);
        }
        playerTable6 = (TableLayout) findViewById(R.id.playerPropertyTable6);
        {
            playerImageView_6_1 = (ImageView) findViewById(R.id.imageView6_1_1);
            playerImageView_6_2 = (ImageView) findViewById(R.id.imageView6_1_2);
            playerImageView_6_3 = (ImageView) findViewById(R.id.imageView6_2_1);
            playerImageView_6_4 = (ImageView) findViewById(R.id.imageView6_2_2);
            playerImageView_6_5 = (ImageView) findViewById(R.id.imageView6_3_1);
            playerImageView_6_6 = (ImageView) findViewById(R.id.imageView6_3_2);
        }


        enemyTable1 = (TableLayout) findViewById(R.id.enemyPropertyTable1);
        {
            enemyImageView_1_1 = (ImageView) findViewById(R.id.imageView7_1_1);
            enemyImageView_1_2 = (ImageView) findViewById(R.id.imageView7_1_2);
            enemyImageView_1_3 = (ImageView) findViewById(R.id.imageView7_2_1);
            enemyImageView_1_4 = (ImageView) findViewById(R.id.imageView7_2_2);
            enemyImageView_1_5 = (ImageView) findViewById(R.id.imageView7_3_1);
            enemyImageView_1_6 = (ImageView) findViewById(R.id.imageView7_3_2);
        }
        enemyTable2 = (TableLayout) findViewById(R.id.enemyPropertyTable2);
        {
            enemyImageView_2_1 = (ImageView) findViewById(R.id.imageView8_1_1);
            enemyImageView_2_2 = (ImageView) findViewById(R.id.imageView8_1_2);
            enemyImageView_2_3 = (ImageView) findViewById(R.id.imageView8_2_1);
            enemyImageView_2_4 = (ImageView) findViewById(R.id.imageView8_2_2);
            enemyImageView_2_5 = (ImageView) findViewById(R.id.imageView8_3_1);
            enemyImageView_2_6 = (ImageView) findViewById(R.id.imageView8_3_2);
        }
        enemyTable3 = (TableLayout) findViewById(R.id.enemyPropertyTable3);
        {
            enemyImageView_3_1 = (ImageView) findViewById(R.id.imageView9_1_1);
            enemyImageView_3_2 = (ImageView) findViewById(R.id.imageView9_1_2);
            enemyImageView_3_3 = (ImageView) findViewById(R.id.imageView9_2_1);
            enemyImageView_3_4 = (ImageView) findViewById(R.id.imageView9_2_2);
            enemyImageView_3_5 = (ImageView) findViewById(R.id.imageView9_3_1);
            enemyImageView_3_6 = (ImageView) findViewById(R.id.imageView9_3_2);
        }
        enemyTable4 = (TableLayout) findViewById(R.id.enemyPropertyTable4);
        {
            enemyImageView_4_1 = (ImageView) findViewById(R.id.imageView10_1_1);
            enemyImageView_4_2 = (ImageView) findViewById(R.id.imageView10_1_2);
            enemyImageView_4_3 = (ImageView) findViewById(R.id.imageView10_2_1);
            enemyImageView_4_4 = (ImageView) findViewById(R.id.imageView10_2_2);
            enemyImageView_4_5 = (ImageView) findViewById(R.id.imageView10_3_1);
            enemyImageView_4_6 = (ImageView) findViewById(R.id.imageView10_3_2);
        }
        enemyTable5 = (TableLayout) findViewById(R.id.enemyPropertyTable5);
        {
            enemyImageView_5_1 = (ImageView) findViewById(R.id.imageView11_1_1);
            enemyImageView_5_2 = (ImageView) findViewById(R.id.imageView11_1_2);
            enemyImageView_5_3 = (ImageView) findViewById(R.id.imageView11_2_1);
            enemyImageView_5_4 = (ImageView) findViewById(R.id.imageView11_2_2);
            enemyImageView_5_5 = (ImageView) findViewById(R.id.imageView11_3_1);
            enemyImageView_5_6 = (ImageView) findViewById(R.id.imageView11_3_2);
        }
        enemyTable6 = (TableLayout) findViewById(R.id.enemyPropertyTable6);
        {
            enemyImageView_6_1 = (ImageView) findViewById(R.id.imageView12_1_1);
            enemyImageView_6_2 = (ImageView) findViewById(R.id.imageView12_1_2);
            enemyImageView_6_3 = (ImageView) findViewById(R.id.imageView12_2_1);
            enemyImageView_6_4 = (ImageView) findViewById(R.id.imageView12_2_2);
            enemyImageView_6_5 = (ImageView) findViewById(R.id.imageView12_3_1);
            enemyImageView_6_6 = (ImageView) findViewById(R.id.imageView12_3_2);
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

        room.addPlayer(new Player());
        room.addPlayer(new Player());

        refresh();

    }

    public void refresh() {
        refreshAnimalsPropertes();
        refreshAnimals();
    }

    private void refreshAnimals() {

        refreshAnimalsPropertes();

        List<Animal> animalList = room.getAnimalsList();
        int[] playerAnimlCount = new int[room.numberPlayers()];
        for (int i = 0; i < room.getAnimalsList().size(); i++) {
            for (int j = 0; j < room.numberPlayers(); j++) {
                if (animalList.get(i).getPlayer() == room.getPlayers().get(j)) {
                    playerAnimlCount[j]++;
                }
            }
        }
        if (isServer) {
            switch (playerAnimlCount[0]) {
                case 1: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 2: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 3: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 4: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 5: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 6: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.VISIBLE);
                }
            }
            switch (playerAnimlCount[1]) {
                case 1: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 2: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 3: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 4: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 5: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 6: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.VISIBLE);
                }
            }
        } else {
            switch (playerAnimlCount[1]) {
                case 1: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.INVISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 2: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.INVISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 3: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.INVISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 4: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.INVISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 5: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.INVISIBLE);
                }
                case 6: {
                    playerAnimal1.setVisibility(View.VISIBLE);
                    playerAnimal2.setVisibility(View.VISIBLE);
                    playerAnimal3.setVisibility(View.VISIBLE);
                    playerAnimal4.setVisibility(View.VISIBLE);
                    playerAnimal5.setVisibility(View.VISIBLE);
                    playerAnimal6.setVisibility(View.VISIBLE);
                }
            }
            switch (playerAnimlCount[0]) {
                case 1: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.INVISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 2: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.INVISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 3: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.INVISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 4: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.INVISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 5: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.INVISIBLE);
                }
                case 6: {
                    enemyAnimal1.setVisibility(View.VISIBLE);
                    enemyAnimal2.setVisibility(View.VISIBLE);
                    enemyAnimal3.setVisibility(View.VISIBLE);
                    enemyAnimal4.setVisibility(View.VISIBLE);
                    enemyAnimal5.setVisibility(View.VISIBLE);
                    enemyAnimal6.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void refreshAnimalsPropertes() {
        List<Animal> animalList = room.getAnimalsList();

        List<Animal> playerAnimals = new ArrayList<>();
        List<Animal> enemyAnimals = new ArrayList<>();

        for (int i = 0; i < room.getAnimalsList().size(); i++) {
            if (isServer) {
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

        refreshPlayerAnimals(playerAnimals);
        refreshEnemyAnimals(enemyAnimals);
    }

    private void refreshPlayerAnimals(List<Animal> playerAnimals) {
        if (playerAnimals.size() == 1) {
            for (int i = 0; i < playerAnimals.get(0).getProperty().size(); i++) {
                refreshProp(playerAnimals.get(0).getProperty().get(i), enemyImageView_1_1);
            }
            if (playerAnimals.size() == 2) {
                for (int i = 0; i < playerAnimals.get(1).getProperty().size(); i++) {
                    refreshProp(playerAnimals.get(1).getProperty().get(i), enemyImageView_1_1);
                }
                if (playerAnimals.size() == 3) {
                    for (int i = 0; i < playerAnimals.get(2).getProperty().size(); i++) {
                        refreshProp(playerAnimals.get(2).getProperty().get(i), enemyImageView_1_1);
                    }
                    if (playerAnimals.size() == 4) {
                        for (int i = 0; i < playerAnimals.get(3).getProperty().size(); i++) {
                            refreshProp(playerAnimals.get(3).getProperty().get(i), enemyImageView_1_1);
                        }
                        if (playerAnimals.size() == 5) {
                            for (int i = 0; i < playerAnimals.get(4).getProperty().size(); i++) {
                                refreshProp(playerAnimals.get(4).getProperty().get(i), enemyImageView_1_1);
                            }
                            if (playerAnimals.size() == 6) {
                                for (int i = 0; i < playerAnimals.get(5).getProperty().size(); i++) {
                                    refreshProp(playerAnimals.get(5).getProperty().get(i), enemyImageView_1_1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void refreshEnemyAnimals(List<Animal> enemyAnimals) {
        if (enemyAnimals.size() == 1) {
            for (int i = 0; i < enemyAnimals.get(0).getProperty().size(); i++) {
                refreshProp(enemyAnimals.get(0).getProperty().get(i), enemyImageView_1_1);
            }
            if (enemyAnimals.size() == 2) {
                for (int i = 0; i < enemyAnimals.get(1).getProperty().size(); i++) {
                    refreshProp(enemyAnimals.get(1).getProperty().get(i), enemyImageView_1_1);
                }
                if (enemyAnimals.size() == 3) {
                    for (int i = 0; i < enemyAnimals.get(2).getProperty().size(); i++) {
                        refreshProp(enemyAnimals.get(2).getProperty().get(i), enemyImageView_1_1);
                    }
                    if (enemyAnimals.size() == 4) {
                        for (int i = 0; i < enemyAnimals.get(3).getProperty().size(); i++) {
                            refreshProp(enemyAnimals.get(3).getProperty().get(i), enemyImageView_1_1);
                        }
                        if (enemyAnimals.size() == 5) {
                            for (int i = 0; i < enemyAnimals.get(4).getProperty().size(); i++) {
                                refreshProp(enemyAnimals.get(4).getProperty().get(i), enemyImageView_1_1);
                            }
                            if (enemyAnimals.size() == 6) {
                                for (int i = 0; i < enemyAnimals.get(5).getProperty().size(); i++) {
                                    refreshProp(enemyAnimals.get(5).getProperty().get(i), enemyImageView_1_1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void refreshProp(Property property, ImageView enemyImageView) {
        switch (property.getValue()) {
            case BURROWING: {
                enemyImageView.setImageResource(R.drawable.burrowing_prp);
                break;
            }
            case CAMOUFLAGE: {
                enemyImageView.setImageResource(R.drawable.camouflage_prp);
                break;
            }
            case CARNIVOROUS: {
                enemyImageView.setImageResource(R.drawable.carnivorous_prp);
                break;
            }
            case COMMUNICATION: {
                enemyImageView.setImageResource(R.drawable.communication_prp);
                break;
            }
            case COOPERATION: {
                enemyImageView.setImageResource(R.drawable.cooperation_prp);
                break;
            }
            case GRAZING: {
                enemyImageView.setImageResource(R.drawable.grazing_prp);
                break;
            }
            case HIBERNATION_ABILITY: {
                enemyImageView.setImageResource(R.drawable.hibernation_ability_prp);
                break;
            }
            case HIGH_BODY_WEIGHT: {
                enemyImageView.setImageResource(R.drawable.high_body_weight_prp);
                break;
            }
            case MIMICRY: {
                enemyImageView.setImageResource(R.drawable.mimicry_prp);
                break;
            }
            case PARASITE: {
                enemyImageView.setImageResource(R.drawable.parasite_prp);
                break;
            }
            case PIRACY: {
                enemyImageView.setImageResource(R.drawable.pirasy_prp);
                break;
            }
            case POISONOUS: {
                enemyImageView.setImageResource(R.drawable.poisonous_prp);
                break;
            }
            case RUNNING: {
                enemyImageView.setImageResource(R.drawable.running_prp);
                break;
            }
            case SCAVENGER: {
                enemyImageView.setImageResource(R.drawable.scavenger_prp);
                break;
            }
            case SHARP_VISION: {
                enemyImageView.setImageResource(R.drawable.sharp_vision__prp);
                break;
            }
            case SWIMMING: {
                enemyImageView.setImageResource(R.drawable.swimming_prp);
                break;
            }
            case SYMBIOSYS: {
                enemyImageView.setImageResource(R.drawable.symbiosis_prp);
                break;
            }
            case TAIL_LOSS: {
                enemyImageView.setImageResource(R.drawable.tail_loss_prp);
                break;
            }
            default: {
                enemyImageView.setImageResource(R.drawable.evolution_prp);
                break;
            }
        }
    }
}
