package com.example.pc.evolutiongame.logic;

public class CubeThrower {
    public static int cubeThrow() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int cubeThrow(int timesCount) {
        int localNum = 0;
        for (int i = 0; i < timesCount; i++) {
            localNum += cubeThrow();
        }
        return localNum;
    }
}
