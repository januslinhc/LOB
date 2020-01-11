package com.janus.orderbook.msg;

public class AddOrderMsg extends BATSMessage<IAddOrderMsg> implements IAddOrderMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
    private char side;
    private long shares;
    private String symbol;
    private long price;
    private char display;
    private String partId;

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public char getMsgType() {
        return this.msgType;
    }

    @Override
    public long getOrderId() {
        return this.orderId;
    }

    @Override
    public char getSide() {
        return this.side;
    }

    @Override
    public long getShares() {
        return this.shares;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public char getDisplay() {
        return this.display;
    }

    @Override
    public String getPartId() {
        return this.partId;
    }
}
