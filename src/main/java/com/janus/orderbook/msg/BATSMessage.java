package com.janus.orderbook.msg;

import java.util.Optional;

/**
 * The type Bats message.
 *
 * @param <T> the type parameter
 */
public abstract class BATSMessage<T> implements IBATSMessage {
    /**
     * Into optional.
     *
     * @return the optional
     */
    Optional<T> into() {
        return Optional.of((T) this);
    }
}
