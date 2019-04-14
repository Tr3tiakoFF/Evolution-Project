package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Processable;

public class ServerReceiver implements Processable {

    @Override
    public void process(String msg) {
        System.out.printf("Received msg %s%n", msg);
    }
}
