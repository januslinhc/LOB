package com.janus.orderbook.msg;

public interface IOrderCancelMsg {
    long getTimestamp();

    char getMsgType();

    long getOrderId();

    long getShares();
}
