package com.janus.orderbook.msg;

/**
 * The interface Add order msg.
 */
public interface IAddOrderMsg {

    /**
     * Gets order id.
     *
     * @return the order id
     */
    long getOrderId();

    /**
     * Gets side.
     *
     * @return the side
     */
    char getSide();

    /**
     * Gets shares.
     *
     * @return the shares
     */
    long getShares();

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets price.
     *
     * @return the price
     */
    long getPrice();

    /**
     * Gets display.
     *
     * @return the display
     */
    char getDisplay();

    /**
     * Gets part id.
     *
     * @return the part id
     */
    String getPartId();
}
