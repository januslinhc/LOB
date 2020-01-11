package com.janus.orderbook.msg;

/**
 * The interface Order executed msg.
 */
public interface IOrderExecutedMsg {

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

    /**
     * Gets exec id.
     *
     * @return the exec id
     */
    long getExecId();
}
