package com.janus.orderbook.msg;

public interface ITradeBreakMsg {
    long getTimestamp();

    char getMsgType();

    long getExecId();
}
