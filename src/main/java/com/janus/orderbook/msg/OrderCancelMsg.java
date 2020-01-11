package com.janus.orderbook.msg;

public class OrderCancelMsg extends BATSMessage<IOrderCancelMsg> implements IOrderCancelMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
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
    public long getOrderId() {
        return this.orderId;
    }

    @Override
    public long getShares() {
        return this.shares;
    }
}
