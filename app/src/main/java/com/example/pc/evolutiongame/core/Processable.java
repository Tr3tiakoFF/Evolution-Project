package com.example.pc.evolutiongame.core;

public interface Processable {
    void process(Context context, String msg) throws InterruptedException;
}
