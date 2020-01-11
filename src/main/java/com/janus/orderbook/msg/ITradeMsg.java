package com.janus.orderbook.msg;

/**
 * The interface Trade msg.
 */
public interface ITradeMsg {
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
     * Gets exec id.
     *
     * @return the exec id
     */
    long getExecId();
}
