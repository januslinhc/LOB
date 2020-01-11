package com.janus.orderbook.msg;

public interface ITradingStatusMsg {
    long getTimestamp();

    char getMsgType();

    String getSymbol();

    char getHaltStatus();

    char getRegShoAction();

    char getReserved1();

    char getReserved2();
}
