package com.janus.orderbook.msg;

/**
 * The interface Auction summary msg.
 */
public interface IAuctionSummaryMsg {

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets auction type.
     *
     * @return the auction type
     */
    char getAuctionType();

    /**
     * Gets price.
     *
     * @return the price
     */
    long getPrice();

    /**
     * Gets shares.
     *
     * @return the shares
     */
    long getShares();
}
