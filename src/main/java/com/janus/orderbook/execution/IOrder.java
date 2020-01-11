package com.janus.orderbook.execution;

// https://github.com/bigfatwhale/orderbook/tree/master/rust/src
public interface IOrder {
    long getPrice();

    short getSide();

    long getVolume();

    void setVolume(long volume);

    long getOrderID();
}
