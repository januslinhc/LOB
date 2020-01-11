package com.janus.orderbook.execution;

public interface IApplication {
    void start();

    ILimitOrderBook getOrderBook();
}
