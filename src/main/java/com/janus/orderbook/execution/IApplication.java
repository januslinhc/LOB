package com.janus.orderbook.execution;

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
