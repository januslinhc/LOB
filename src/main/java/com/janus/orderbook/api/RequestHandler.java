package com.janus.orderbook.api;

import com.janus.orderbook.execution.ILimitOrderBook;
import com.janus.orderbook.execution.Order;
import com.janus.orderbook.msg.IAddOrderMsg;
import com.janus.orderbook.msg.IBATSMessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestHandler {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void submit(ILimitOrderBook book, IBATSMessage msg) {
        executor.submit(() -> {
            if (msg.getMsgType() == 'A') {
                IAddOrderMsg addOrderMsg = (IAddOrderMsg) msg;

                if (addOrderMsg.getSide() == 'B') {
                    book.addRequest(new Order(((IAddOrderMsg) msg).getOrderId(), ((IAddOrderMsg) msg).getPrice(), ((IAddOrderMsg) msg).getShares(), (short) 0, null));
                } else {
                    book.addRequest(new Order(((IAddOrderMsg) msg).getOrderId(), ((IAddOrderMsg) msg).getPrice(), ((IAddOrderMsg) msg).getShares(), (short) -1, null));
                }

            }
        });
        return;
    }
}
