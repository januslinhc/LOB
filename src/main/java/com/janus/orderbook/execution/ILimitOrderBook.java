package com.janus.orderbook.execution;

public interface ILimitOrderBook extends IOrderManager {
    void startWorkers();

    void addRequest(IOrder order);

    long getBestBid();

    long getBestAsk();

    long getAskVolumeAtPriceLevel(long price);

    long getBidVolumeAtPriceLevel(long price);

    void shutdown();
}
