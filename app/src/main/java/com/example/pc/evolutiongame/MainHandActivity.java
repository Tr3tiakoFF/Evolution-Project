package com.example.pc.evolutiongame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pc.evolutiongame.core.UiRenderer;
import com.example.pc.evolutiongame.logic.CardGiver;
import com.example.pc.evolutiongame.logic.DeckShufler;
import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.LowLevelAnimalProperty;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.pc.evolutiongame.Utils.getNewId;

public class MainHandActivity extends Activity implements UiRenderer {

    Player player;

    ImageView playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, playerCard6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hand_activity);

        playerCard1 = (ImageView) findViewById(R.id.playerCard1);
        playerCard2 = (ImageView) findViewById(R.id.playerCard2);
        playerCard3 = (ImageView) findViewById(R.id.playerCard3);
        playerCard4 = (ImageView) findViewById(R.id.playerCard4);
        playerCard5 = (ImageView) findViewById(R.id.playerCard5);
        playerCard6 = (ImageView) findViewById(R.id.playerCard6);

        Room room = new Room();

        room.addPlayer(new Player(getNewId()));
        room.addPlayer(new Player(getNewId()));
        room.addDeck(DeckShufler.deckShuffle());

        List<List<Card>> cardsForPlayers = CardGiver.getCardsForPlayers(room.numberPlayers(), room.getDeck());

        for (int i = 0; i < room.numberPlayers(); i++) {
            room.getPlayers().get(i).addCards(cardsForPlayers.get(i));
        }

        player = room.getPlayers().get(0);

        render(room);
    }


    @Override
    public void render(Room room) {
        List<Card> hand = new ArrayList<>();

        for (int i = 0; i < room.numberPlayers(); i++) {
            if (room.getPlayers().get(i) == player) {
                hand = room.getPlayers().get(i).getCards();
            }
        }

        if (hand.size() >= 1) {
            renderCard(playerCard1, hand.get(0));
            if (hand.size() >= 2) {
                renderCard(playerCard2, hand.get(1));
                if (hand.size() >= 3) {
                    renderCard(playerCard3, hand.get(2));
                    if (hand.size() >= 4) {
                        renderCard(playerCard4, hand.get(3));
                        if (hand.size() >= 5) {
                            renderCard(playerCard5, hand.get(4));
                            if (hand.size() >= 6) {
                                renderCard(playerCard6, hand.get(5));
                            }
                        }
                    }
                }
            }
        }
    }

    private void renderCard(ImageView playerCard1, Card card) {
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.BURROWING) {
            playerCard1.setImageResource(R.drawable.burrowing_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COMMOUFLAGE) {
            playerCard1.setImageResource(R.drawable.commouflage_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COMMUNICATION) {
            playerCard1.setImageResource(R.drawable.communication_carnivorous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.GRAZING) {
            playerCard1.setImageResource(R.drawable.grazing_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.HIBERNATION_ABILITY) {
            playerCard1.setImageResource(R.drawable.hibernation_ability_carnivorous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.MIMICRY) {
            playerCard1.setImageResource(R.drawable.mimicry_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.PIRACY) {
            playerCard1.setImageResource(R.drawable.piracy_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.POISONOUS) {
            playerCard1.setImageResource(R.drawable.poisonous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.RUNNING) {
            playerCard1.setImageResource(R.drawable.running_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SCAVENGER) {
            playerCard1.setImageResource(R.drawable.scavenger_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SHARP_VISION) {
            playerCard1.setImageResource(R.drawable.sharp_vision_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SWIMMING) {
            playerCard1.setImageResource(R.drawable.swimming_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SYMBIOSYS) {
            playerCard1.setImageResource(R.drawable.symbiosis_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.TAIL_LOSS) {
            playerCard1.setImageResource(R.drawable.tail_loss_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COOPERATION) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard1.setImageResource(R.drawable.cooperation_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard1.setImageResource(R.drawable.cooperation_fat_tissue_174x118);
            }
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.HIGH_BODY_WEIGHT) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard1.setImageResource(R.drawable.high_body_weight_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard1.setImageResource(R.drawable.high_body_weight_fat_tissue_174x118);
            }
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.PARASITE) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard1.setImageResource(R.drawable.parasite_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard1.setImageResource(R.drawable.parasite_fat_tissue_174x118);
            }
        }
    }
}
