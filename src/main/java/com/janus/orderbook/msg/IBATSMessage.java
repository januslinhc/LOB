package com.janus.orderbook.msg;

/**
 * The interface Ibats message.
 */
public interface IBATSMessage {
    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    long getTimeStamp();

    /**
     * Gets msg type.
     *
     * @return the msg type
     */
    char getMsgType();
}
