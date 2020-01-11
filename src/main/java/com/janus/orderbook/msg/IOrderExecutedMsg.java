package com.janus.orderbook.msg;

/**
 * The interface Order executed msg.
 */
public interface IOrderExecutedMsg {
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

    /**
     * Gets exec id.
     *
     * @return the exec id
     */
    long getExecId();
}
