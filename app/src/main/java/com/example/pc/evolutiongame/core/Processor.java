package com.example.pc.evolutiongame.core;

public interface Processor {
    void process(EvolutionContext evolutionContext, String msg) throws InterruptedException;
}
