package com.example.pc.evolutiongame;

import java.util.Random;

public class Utils {
    private static Random rand = new Random(System.currentTimeMillis());

    public static String getNewId() {
        return String.format("%04X", rand.nextInt());
    }
}
