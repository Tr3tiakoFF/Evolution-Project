package com.example.pc.evolutiongame.logic;

public class FoodGenerator {
    public static int generateFood(int playerCount) {
        switch (playerCount) {
            case 2:
                return CubeThrower.cubeThrow(1) + 2;
            case 3:
                return CubeThrower.cubeThrow(2);
            case 4:
                return CubeThrower.cubeThrow(2) + 2;
            case 5:
                return CubeThrower.cubeThrow(3) + 2;
            case 6:
                return CubeThrower.cubeThrow(3) + 3;
            default:
                return 0;
        }
    }
}
