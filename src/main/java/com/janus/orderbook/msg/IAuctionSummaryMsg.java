package com.janus.orderbook.msg;

public interface IAuctionSummaryMsg {
    long getTimestamp();

    char getMsgType();

    String getSymbol();

    char getAuctionType();

    long getPrice();

    long getShares();
}
