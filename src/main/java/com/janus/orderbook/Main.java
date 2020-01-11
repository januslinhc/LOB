package com.janus.orderbook;

import com.janus.orderbook.execution.Order;

public class Main {
    // -1 is ask / buy
    // 0 is bid / sell

    public static void main(String[] args) {
        IApplication app = Application.getInstance();
        app.getOrderBook().addRequest(new Order(1, 30, 100, (short) 0, null));
        app.getOrderBook().addRequest(new Order(1, 40, 100, (short) 0, null));
        app.getOrderBook().addRequest(new Order(2, 20, 200, (short) -1, null));
        //  app.getOrderBook().addRequest(new Order(3, 5, 50, (short) 0, null));
        // app.getOrderBook().addRequest(new Order(4, 10, 50, (short) 0, null));

        //System.out.println(app.getOrderBook().getBestAsk());
        //System.out.println(app.getOrderBook().getBestBid());

    }
}
