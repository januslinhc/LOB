package com.janus.orderbook.msg;

public interface ITradeMsg {
    long getTimestamp();

    char getMsgType();

    long getOrderId();

    char getSide();

    long getShares();

    String getSymbol();

    long getPrice();

    long getExecId();
}
