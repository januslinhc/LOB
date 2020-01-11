package com.janus.orderbook.msg;

public interface IOrderExecutedMsg {
    long getTimestamp();

    char getMsgType();

    long getOrderId();

    long getShares();

    long getExecId();
}
