package com.janus.orderbook.marketFeed;

import com.janus.orderbook.execution.ILimitOrderBook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MarketEventChange {
    public static List<FeedClientHandler> clients = new ArrayList<>();

    public static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void startTracking(ILimitOrderBook book) {
        executor.submit(() -> {
            long bidPrice;
            long askPrice;
            //String msg;

            while (true) {
                bidPrice = book.getBestBid();
                askPrice = book.getBestAsk();
                final String msg = genMsg(bidPrice, askPrice);
                clients.forEach(feedClientHandler -> feedClientHandler.send(msg));
                Thread.sleep(300);
            }
        });
    }

    public static String genMsg(long bid, long ask) {
        StringBuilder builder = new StringBuilder();
        builder.append(bid);
        builder.append(";");
        builder.append(ask);
        builder.append("\n");
        return builder.toString();
    }
}
