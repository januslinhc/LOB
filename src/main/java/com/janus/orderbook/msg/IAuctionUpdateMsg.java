package com.janus.orderbook.msg;

public interface IAuctionUpdateMsg {
    long getTimestamp();

    char getMsgType();

    String getSymbol();

    char getAuctionType();

    long getReferencePrice();

    long getBuyShares();

    long getSellShares();

    long getIndicativePrice();

    long getAuctionOnlyPrice();
}
