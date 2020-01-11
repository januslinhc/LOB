package com.janus.orderbook.marketFeed;

import com.janus.orderbook.execution.ILimitOrderBook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class FeedClientHandler extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(FeedClientHandler.class);
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    final ILimitOrderBook book;

    public FeedClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, ILimitOrderBook book) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.book = book;
    }

    @Override
    public void run() {
        MarketEventChange.clients.add(this);
    }

    public void send(final String msg) {
        try {
            this.dos.writeUTF(msg);
            this.dos.flush();
        } catch (SocketException e) {
            MarketEventChange.clients.remove(this);
            try {
                // closing resources
                this.dis.close();
                this.dos.close();
                MarketEventChange.clients.remove(this);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
