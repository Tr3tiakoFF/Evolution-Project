package com.example.pc.evolutiongame.core.client;

import com.example.pc.evolutiongame.core.Processable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static com.example.pc.evolutiongame.Configuration.getClientConfiguration;
import static com.example.pc.evolutiongame.core.server.TcpServer.SERVER_HOST;
import static com.example.pc.evolutiongame.core.server.TcpServer.SERVER_PORT;
import static java.lang.Thread.sleep;

public class TcpClient {
    private Socket clientSocket;
    private PrintWriter out;
    private final Processable processable;

    public TcpClient(Processable processable) {
        this.processable = processable;
    }

    public void createConnection(final String ip, final int port) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("Trying to start tcp client");
                    InetAddress serverAddr = InetAddress.getByName(ip);
                    clientSocket = new Socket(serverAddr, port);
                    System.out.printf("Client %s started to->%s%n", clientSocket.getLocalSocketAddress(), clientSocket.getRemoteSocketAddress());
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (!Thread.interrupted()) {
                                try {
                                    String msg = in.readLine();
                                    System.out.printf("Received msg from->%s%n", clientSocket.getRemoteSocketAddress());
                                    processable.process(msg);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(final String msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (clientSocket != null && !clientSocket.isClosed()) {
                    out.println(msg);
                    System.out.println("MsgSent " + msg);
                }
            }
        }).start();
    }

    public void stopConnection() throws IOException {
        System.out.println("ConnectionStopped");
        clientSocket.shutdownOutput();
    }

    public static void main(String[] args) {
        TcpClient client = getClientConfiguration();
        client.createConnection(SERVER_HOST, SERVER_PORT);

//        for (int i = 0; i < 100; i++) {
//            client.sendMessage("Hi from all of us " + i);
//            sleep(300);
//        }
//        client.stopConnection();
    }
}
