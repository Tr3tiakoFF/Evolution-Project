package com.example.pc.evolutiongame.core;

public interface Processable {
    void process(EvolutionContext evolutionContext, String msg) throws InterruptedException;
}
