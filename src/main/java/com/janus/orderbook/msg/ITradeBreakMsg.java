package com.janus.orderbook.msg;

/**
 * The interface Trade break msg.
 */
public interface ITradeBreakMsg {
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
     * Gets exec id.
     *
     * @return the exec id
     */
    long getExecId();
}
