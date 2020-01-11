package com.janus.orderbook.msg;

public class OrderExecutedMsg extends BATSMessage<IOrderExecutedMsg> implements IOrderExecutedMsg {
    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public char getMsgType() {
        return 0;
    }

    @Override
    public long getOrderId() {
        return 0;
    }

    @Override
    public long getShares() {
        return 0;
    }

    @Override
    public long getExecId() {
        return 0;
    }
}
