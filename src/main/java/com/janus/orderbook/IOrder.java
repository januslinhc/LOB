package com.janus.orderbook;

// https://github.com/bigfatwhale/orderbook/tree/master/rust/src
public interface IOrder {
    long getPrice();

    short getSide();

    long getVolume();
}
