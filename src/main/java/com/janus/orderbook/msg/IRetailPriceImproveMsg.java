package com.janus.orderbook.msg;

public interface IRetailPriceImproveMsg {
    long getTimestamp();

    char getMsgType();

    String getSymbol();

    char getRetailPriceImprove();
}
