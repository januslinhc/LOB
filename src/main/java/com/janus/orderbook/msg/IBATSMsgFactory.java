package com.janus.orderbook.msg;

import java.util.Optional;

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
    Optional<IBATSMessage> parse(String str);
}
