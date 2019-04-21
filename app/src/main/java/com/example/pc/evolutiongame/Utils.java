package com.example.pc.evolutiongame;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.pc.evolutiongame.model.Animal;
import com.example.pc.evolutiongame.model.Player;
import com.example.pc.evolutiongame.model.Property;
import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Utils {
    private static Random rand = new Random(System.currentTimeMillis());

    public static String getNewId() {
        return String.format("%04X", rand.nextInt());
    }

    public static List<Player> getEnemyPlayers(String playerId, Room room) {
        List<Player> players = new ArrayList<>();
        for (Player player : room.getPlayers()) {
            if (!playerId.equals(player.getId())) {
                players.add(player);
            }
        }
        return players;
    }

    public static Player getPlayer(String playerId, Room room) {
        for (Player player : room.getPlayers()) {
            if (playerId.equals(player.getId())) {
                return player;
            }
        }
        return null;
    }

    public static List<Animal> getPlayerAnimals(Player player, Room room) {
        List<Animal> playerAnimals = new CopyOnWriteArrayList<>();
        for (Animal animal : room.getAnimals()) {
            if (player.getId().equals(animal.getPlayer().getId())) {
                playerAnimals.add(animal);
            }
        }
        return playerAnimals;
    }

    public static List<Animal> renderPlayerInfo(Player player, Room room, ViewGroup playerLayout) {
        List<Animal> playerAnimals = getPlayerAnimals(player, room);

        for (int i = 0; i < playerLayout.getChildCount(); i++) {
            View animalView = playerLayout.getChildAt(i);
            if (animalView instanceof Button) {
                animalView.setVisibility(View.INVISIBLE);
            }
        }

        for (int i = 0; i < playerAnimals.size(); i++) {
            ViewGroup view = (ViewGroup) playerLayout.getChildAt(i);
            for (int j = 0; j < view.getChildCount(); j++) {
                View animalView = view.getChildAt(i);
                if (animalView instanceof Button) {
                    animalView.setVisibility(View.VISIBLE);
                }

                if (animalView instanceof TableLayout) {
                    Animal animal = playerAnimals.get(i);
                    List<Property> properties = animal.getProperties();
                    if (!properties.isEmpty()) {
                        Iterator<Property> iterator = properties.iterator();
                        for (int k = 0; k < ((ViewGroup) animalView).getChildCount(); k++) {
                            View tableRowView = ((ViewGroup) animalView).getChildAt(k);
                            for (int l = 0; l < ((ViewGroup) tableRowView).getChildCount(); l++) {
                                View imgView = ((ViewGroup) tableRowView).getChildAt(l);
                                if (imgView instanceof ImageView) {
                                    if (iterator.hasNext()) {
                                        renderProp(iterator.next(), (ImageView) imgView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return playerAnimals;
    }

    private static void renderProp(Property property, ImageView imageView) {
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
}
