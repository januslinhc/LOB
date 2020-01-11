package com.janus.orderbook;

import com.janus.orderbook.execution.ILimitOrderBook;

/**
 * The interface Application.
 */
public interface IApplication {
    /**
     * Start.
     */
    void start();

    /**
     * Gets order book.
     *
     * @return the order book
     */
    ILimitOrderBook getOrderBook();
}
