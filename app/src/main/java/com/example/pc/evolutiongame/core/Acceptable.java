package com.example.pc.evolutiongame.core;

import java.net.Socket;

public interface Acceptable {
    void accept(Socket clientSocket, EvolutionContext evolutionContext);
}
