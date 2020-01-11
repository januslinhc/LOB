package com.janus.orderbook.execution;

/**
 * The interface Limit order book.
 */
public interface ILimitOrderBook extends IOrderManager {
    /**
     * Start workers.
     */
    void startWorkers();

    /**
     * Add request.
     *
     * @param order the order
     */
    void addRequest(IOrder order);

    /**
     * Gets best bid.
     *
     * @return the best bid
     */
    long getBestBid();

    /**
     * Gets best ask.
     *
     * @return the best ask
     */
    long getBestAsk();

    /**
     * Gets ask volume at price level.
     *
     * @param price the price
     * @return the ask volume at price level
     */
    long getAskVolumeAtPriceLevel(long price);

    /**
     * Gets bid volume at price level.
     *
     * @param price the price
     * @return the bid volume at price level
     */
    long getBidVolumeAtPriceLevel(long price);

    /**
     * Shutdown.
     */
    void shutdown();
}
