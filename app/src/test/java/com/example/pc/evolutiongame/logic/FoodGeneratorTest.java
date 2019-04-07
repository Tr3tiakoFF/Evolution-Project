package com.example.pc.evolutiongame.logic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FoodGeneratorTest {
    @Test
    public void foodGenerator_2Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 3);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 8);
    }

    @Test
    public void foodGenerator_3Player() {
        Assert.assertTrue(FoodGenerator.generateFood(3) >= 2);
        Assert.assertTrue(FoodGenerator.generateFood(3) <= 12);
    }

    @Test
    public void foodGenerator_4Player() {
        Assert.assertTrue(FoodGenerator.generateFood(4) >= 4);
        Assert.assertTrue(FoodGenerator.generateFood(4) <= 14);
    }

    @Test
    public void foodGenerator_5Player() {
        Assert.assertTrue(FoodGenerator.generateFood(5) >= 5);
        Assert.assertTrue(FoodGenerator.generateFood(5) <= 20);
    }

    @Test
    public void foodGenerator_6Player() {
        Assert.assertTrue(FoodGenerator.generateFood(6) >= 6);
        Assert.assertTrue(FoodGenerator.generateFood(6) <= 20);
    }
}