package com.janus.orderbook.marketFeed;

import com.janus.orderbook.execution.ILimitOrderBook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FeedServer {
    private static final Logger LOGGER = LogManager.getLogger(FeedServer.class);

    public static void start(ILimitOrderBook limitOrderBook) throws IOException {
        ServerSocket ss = new ServerSocket(3056);
        MarketEventChange.startTracking(limitOrderBook);

        while (true) {
            Socket s = null;

            try {
                s = ss.accept();
                LOGGER.debug(String.format("new client is connected: %s", s));
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                // create a new thread object
                Thread t = new FeedClientHandler(s, dis, dos, limitOrderBook);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}
