package com.janus.orderbook.msg;

public class AuctionUpdateMsg extends BATSMessage<IAuctionUpdateMsg> implements IAuctionUpdateMsg {
    private long timestamp;
    private char msgType;
    private String symbol;
    private char auctionType;
    private long referencePrice;
    private long buyShares;
    private long sellShares;
    private long indicativePrice;
    private long auctionOnlyPrice;

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
    public long getReferencePrice() {
        return this.referencePrice;
    }

    @Override
    public long getBuyShares() {
        return this.buyShares;
    }

    @Override
    public long getSellShares() {
        return this.sellShares;
    }

    @Override
    public long getIndicativePrice() {
        return this.indicativePrice;
    }

    @Override
    public long getAuctionOnlyPrice() {
        return this.auctionOnlyPrice;
    }
}
