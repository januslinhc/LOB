package com.janus.orderbook.msg;

/**
 * The interface Order cancel msg.
 */
public interface IOrderCancelMsg {

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
