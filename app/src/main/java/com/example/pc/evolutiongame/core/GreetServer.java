package com.example.pc.evolutiongame.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private InputStream inputStream;

    public void start(final int port) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port);
                    clientSocket = serverSocket.accept();
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    inputStream = clientSocket.getInputStream();
                    in = new BufferedReader(new InputStreamReader(inputStream));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (!Thread.interrupted()) {
                                    //CharBuffer charBuffer = CharBuffer.allocate(1024);
                                    byte[] bytes = new byte[1024];
                                    int readBytes = inputStream.read(bytes);
                                    if (readBytes == -1) {
                                        System.out.println("Client is closed!");
                                        break;
                                    }
                                    String greeting = new String(bytes);
                                    System.out.println(greeting);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        String greeting = in.readLine();
//        if ("hello server".equals(greeting)) {
//            out.println("hello client");
//        }
//        else {
//            out.println("unrecognised greeting");
//        }
//        System.out.println(greeting);
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        GreetServer server=new GreetServer();
        server.start(6666);
    }
}