package com.janus.orderbook.msg;

import java.util.Optional;

public abstract class BATSMessage<T> implements IBATSMessage {
    Optional<T> into() {
        return Optional.of((T) this);
    }
}
