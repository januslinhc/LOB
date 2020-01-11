package com.janus.orderbook.msg;

/**
 * The interface Retail price improve msg.
 */
public interface IRetailPriceImproveMsg {
    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    long getTimestamp();

    /**
     * Gets msg type.
     *
     * @return the msg type
     */
    char getMsgType();

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets retail price improve.
     *
     * @return the retail price improve
     */
    char getRetailPriceImprove();
}
