package com.janus.orderbook.msg;

public class AuctionSummaryMsg extends BATSMessage<IAuctionSummaryMsg> implements IAuctionSummaryMsg {
    private long timestamp;
    private char msgType;
    private String symbol;
    private char auctionType;
    private long price;
    private long shares;

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public char getMsgType() {
        return this.msgType;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public char getAuctionType() {
        return this.auctionType;
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public long getShares() {
        return this.shares;
    }
}
