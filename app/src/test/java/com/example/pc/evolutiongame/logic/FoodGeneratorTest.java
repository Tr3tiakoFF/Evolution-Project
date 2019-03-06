package com.example.pc.evolutiongame.logic;

import org.junit.Assert;
import org.junit.Test;

public class FoodGeneratorTest {
    @Test
    public void foodGenerator_2Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 3);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 8);
    }

    @Test
    public void foodGenerator_3Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 2);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 12);
    }

    @Test
    public void foodGenerator_4Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 4);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 14);
    }

    @Test
    public void foodGenerator_5Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 5);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 20);
    }

    @Test
    public void foodGenerator_6Player() {
        Assert.assertTrue(FoodGenerator.generateFood(2) >= 6);
        Assert.assertTrue(FoodGenerator.generateFood(2) <= 20);
    }
}