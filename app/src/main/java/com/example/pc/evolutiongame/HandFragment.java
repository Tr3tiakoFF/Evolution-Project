package com.example.pc.evolutiongame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pc.evolutiongame.model.Card;
import com.example.pc.evolutiongame.model.LowLevelAnimalProperty;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.R;

import java.util.List;

import static com.example.pc.evolutiongame.Utils.getPlayer;

public class HandFragment extends Fragment {

    public static final String TAG = "evolutiongame";

    Button playLikeAnimal1, playLikeAnimal2, playLikeAnimal3, playLikeAnimal4, playLikeAnimal5, playLikeAnimal6;
    Button playLikeFirstProp1, playLikeFirstProp2, playLikeFirstProp3, playLikeFirstProp4, playLikeFirstProp5, playLikeFirstProp6;
    Button playLikeSecondProp1, playLikeSecondProp2, playLikeSecondProp3, playLikeSecondProp4, playLikeSecondProp5, playLikeSecondProp6;

    ImageView playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, playerCard6;
    private View view;
    private Room room;
    private List<Card> hand;
    private Player player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hand, container, false);

        playerCard1 = (ImageView) view.findViewById(R.id.playerCard1);
        playerCard2 = (ImageView) view.findViewById(R.id.playerCard2);
        playerCard3 = (ImageView) view.findViewById(R.id.playerCard3);
        playerCard4 = (ImageView) view.findViewById(R.id.playerCard4);
        playerCard5 = (ImageView) view.findViewById(R.id.playerCard5);
        playerCard6 = (ImageView) view.findViewById(R.id.playerCard6);

        playLikeAnimal1 = (Button) view.findViewById(R.id.playAnimal1);
        playLikeAnimal2 = (Button) view.findViewById(R.id.playAnimal2);
        playLikeAnimal3 = (Button) view.findViewById(R.id.playAnimal3);
        playLikeAnimal4 = (Button) view.findViewById(R.id.playAnimal4);
        playLikeAnimal5 = (Button) view.findViewById(R.id.playAnimal5);
        playLikeAnimal6 = (Button) view.findViewById(R.id.playAnimal6);

        playLikeFirstProp1 = (Button) view.findViewById(R.id.Prop1_1);
        playLikeFirstProp2 = (Button) view.findViewById(R.id.Prop2_1);
        playLikeFirstProp3 = (Button) view.findViewById(R.id.Prop3_1);
        playLikeFirstProp4 = (Button) view.findViewById(R.id.Prop4_1);
        playLikeFirstProp5 = (Button) view.findViewById(R.id.Prop5_1);
        playLikeFirstProp6 = (Button) view.findViewById(R.id.Prop6_1);

        playLikeSecondProp1 = (Button) view.findViewById(R.id.Prop1_2);
        playLikeSecondProp2 = (Button) view.findViewById(R.id.Prop2_2);
        playLikeSecondProp3 = (Button) view.findViewById(R.id.Prop3_2);
        playLikeSecondProp4 = (Button) view.findViewById(R.id.Prop4_2);
        playLikeSecondProp5 = (Button) view.findViewById(R.id.Prop5_2);
        playLikeSecondProp6 = (Button) view.findViewById(R.id.Prop6_2);

//        TODO
        playLikeAnimal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 0);
                refreshFragment();
            }
        });
        playLikeAnimal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 1);
                refreshFragment();
            }
        });
        playLikeAnimal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 2);
                refreshFragment();
            }
        });
        playLikeAnimal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 3);
                refreshFragment();
            }
        });
        playLikeAnimal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 4);
                refreshFragment();
            }
        });
        playLikeAnimal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playAnimal(room.getField(), 5);
                refreshFragment();
            }
        });

        refreshFragment();

        return view;
    }


    public void refreshRoom(String playerId, Room room) {
        System.out.printf("Trying hand for room->%s", room);
        this.room = room;
        player = getPlayer(playerId, room);
        hand = player.getCards();

        if (view == null) {
            return;
        }

        refreshFragment();
    }

    private void refreshFragment() {
        playerCard6.setVisibility(View.VISIBLE);
        playerCard1.setVisibility(View.VISIBLE);
        playerCard2.setVisibility(View.VISIBLE);
        playerCard3.setVisibility(View.VISIBLE);
        playerCard4.setVisibility(View.VISIBLE);
        playerCard5.setVisibility(View.VISIBLE);

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
                            } else {
                                playerCard6.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            playerCard6.setVisibility(View.INVISIBLE);
                            playerCard5.setVisibility(View.INVISIBLE);
                        }
                    } else {
                        playerCard6.setVisibility(View.INVISIBLE);
                        playerCard4.setVisibility(View.INVISIBLE);
                        playerCard5.setVisibility(View.INVISIBLE);
                    }
                } else {
                    playerCard6.setVisibility(View.INVISIBLE);
                    playerCard3.setVisibility(View.INVISIBLE);
                    playerCard4.setVisibility(View.INVISIBLE);
                    playerCard5.setVisibility(View.INVISIBLE);
                }
            } else {
                playerCard6.setVisibility(View.INVISIBLE);
                playerCard2.setVisibility(View.INVISIBLE);
                playerCard3.setVisibility(View.INVISIBLE);
                playerCard4.setVisibility(View.INVISIBLE);
                playerCard5.setVisibility(View.INVISIBLE);
            }
        } else {
            playerCard6.setVisibility(View.INVISIBLE);
            playerCard1.setVisibility(View.INVISIBLE);
            playerCard2.setVisibility(View.INVISIBLE);
            playerCard3.setVisibility(View.INVISIBLE);
            playerCard4.setVisibility(View.INVISIBLE);
            playerCard5.setVisibility(View.INVISIBLE);
        }
    }

    private void renderCard(ImageView playerCard, Card card) {
        if (playerCard == null) {
            System.out.println("playerCard is null");
            return;
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.BURROWING) {
            playerCard.setImageResource(R.drawable.burrowing_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COMMOUFLAGE) {
            playerCard.setImageResource(R.drawable.commouflage_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COMMUNICATION) {
            playerCard.setImageResource(R.drawable.communication_carnivorous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.GRAZING) {
            playerCard.setImageResource(R.drawable.grazing_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.HIBERNATION_ABILITY) {
            playerCard.setImageResource(R.drawable.hibernation_ability_carnivorous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.MIMICRY) {
            playerCard.setImageResource(R.drawable.mimicry_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.PIRACY) {
            playerCard.setImageResource(R.drawable.piracy_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.POISONOUS) {
            playerCard.setImageResource(R.drawable.poisonous_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.RUNNING) {
            playerCard.setImageResource(R.drawable.running_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SCAVENGER) {
            playerCard.setImageResource(R.drawable.scavenger_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SHARP_VISION) {
            playerCard.setImageResource(R.drawable.sharp_vision_fat_tissue_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SWIMMING) {
            playerCard.setImageResource(R.drawable.swimming_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.SYMBIOSYS) {
            playerCard.setImageResource(R.drawable.symbiosis_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.TAIL_LOSS) {
            playerCard.setImageResource(R.drawable.tail_loss_174x118);
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.COOPERATION) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard.setImageResource(R.drawable.cooperation_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard.setImageResource(R.drawable.cooperation_fat_tissue_174x118);
            }
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.HIGH_BODY_WEIGHT) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard.setImageResource(R.drawable.high_body_weight_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard.setImageResource(R.drawable.high_body_weight_fat_tissue_174x118);
            }
        }
        if (card.getProperties().get(0).getValue() == LowLevelAnimalProperty.PARASITE) {
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.CARNIVOROUS) {
                playerCard.setImageResource(R.drawable.parasite_carnivorous_174x118);
            }
            if (card.getProperties().get(1).getValue() == LowLevelAnimalProperty.FAT_TISSUE) {
                playerCard.setImageResource(R.drawable.parasite_fat_tissue_174x118);
            }
        }
    }
}
