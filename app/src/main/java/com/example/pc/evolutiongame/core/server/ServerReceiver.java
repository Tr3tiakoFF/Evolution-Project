package com.example.pc.evolutiongame.core.server;

import com.example.pc.evolutiongame.core.Context;
import com.example.pc.evolutiongame.core.Processable;

public class ServerReceiver implements Processable {

    @Override
    public void process(Context context, String msg) {
        System.out.printf("Received msg %s%n", msg);
    }
}
