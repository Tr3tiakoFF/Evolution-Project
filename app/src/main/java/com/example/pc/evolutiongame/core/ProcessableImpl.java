package com.example.pc.evolutiongame.core;

class ProcessableImpl implements Processable {
    @Override
    public void process(String msg) {
        System.out.printf("Received msg %s%n", msg);
    }
}
