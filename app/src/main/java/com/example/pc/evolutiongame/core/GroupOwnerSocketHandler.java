
package com.example.pc.evolutiongame.core;

import android.os.Handler;
import android.util.Log;

import com.example.pc.evolutiongame.wifidirect.discovery.ChatManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.example.pc.evolutiongame.core.server.TcpServer.SERVER_PORT;

/**
 * The implementation of a ServerSocket handler. This is used by the wifi p2p
 * group owner.
 */
public class GroupOwnerSocketHandler extends Thread {

    ServerSocket socket;
    private final int THREAD_COUNT = 10;
    private Handler handler;
    private static final String TAG = "GroupOwnerSocketHandler";

    public GroupOwnerSocketHandler(Handler handler) throws IOException {
        try {
            socket = new ServerSocket(SERVER_PORT);
            this.handler = handler;
            Log.d("GroupOwnerSocketHandler", "Socket Started");
        } catch (IOException e) {
            e.printStackTrace();
            pool.shutdownNow();
            throw e;
        }

    }

    /**
     * A ThreadPool for client sockets.
     */
    private final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            THREAD_COUNT, THREAD_COUNT, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    @Override
    public void run() {
        while (true) {
            try {
                // A blocking operation. Initiate a ChatManager instance when
                // there is a new connection
                pool.execute(new ChatManager(socket.accept(), handler));
                Log.d(TAG, "Launching the I/O handler");

            } catch (IOException e) {
                try {
                    if (socket != null && !socket.isClosed())
                        socket.close();
                } catch (IOException ioe) {

                }
                e.printStackTrace();
                pool.shutdownNow();
                break;
            }
        }
    }

}
