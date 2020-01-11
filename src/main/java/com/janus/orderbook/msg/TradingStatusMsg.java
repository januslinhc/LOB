package com.janus.orderbook.msg;

/**
 * The type Trading status msg.
 */
public class TradingStatusMsg extends BATSMessage<ITradingStatusMsg> implements ITradingStatusMsg {
    private long timestamp;
    private char msgType;
    private String symbol;
    private char haltStatus;
    private char regShoAction;
    private char reserved1;
    private char reserved2;


    @Override
    public long getTimeStamp() {
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
    public char getHaltStatus() {
        return this.haltStatus;
    }

    @Override
    public char getRegShoAction() {
        return this.regShoAction;
    }

    @Override
    public char getReserved1() {
        return this.reserved1;
    }

    @Override
    public char getReserved2() {
        return this.reserved2;
    }
}
