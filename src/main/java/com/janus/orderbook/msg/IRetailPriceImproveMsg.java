package com.janus.orderbook.msg;

/**
 * The interface Retail price improve msg.
 */
public interface IRetailPriceImproveMsg {


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
