package com.janus.orderbook.msg;

/**
 * The interface Order cancel msg.
 */
public interface IOrderCancelMsg {
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
     * Gets shares.
     *
     * @return the shares
     */
    long getShares();
}
