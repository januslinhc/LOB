package com.janus.orderbook.msg;

/**
 * The interface Ibats msg factory.
 */
public interface IBATSMsgFactory {
    /**
     * Parse ibats message.
     *
     * @param str the str
     * @return the ibats message
     */
    IBATSMessage parse(String str);
}
