package com.example.pc.evolutiongame.core;

import com.google.gson.Gson;

public class ServerReceiver implements Processable {

    @Override
    public void process(String msg) {
        System.out.printf("Received msg %s%n", msg);
    }
}
