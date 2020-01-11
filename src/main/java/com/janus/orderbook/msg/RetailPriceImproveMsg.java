package com.janus.orderbook.msg;

/**
 * The type Retail price improve msg.
 */
public class RetailPriceImproveMsg extends BATSMessage<IRetailPriceImproveMsg> implements IRetailPriceImproveMsg {
    private long timestamp;
    private char msgType;
    private String symbol;
    private char retailPriceImprove;


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
    public char getRetailPriceImprove() {
        return this.retailPriceImprove;
    }
}
