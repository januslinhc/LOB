package com.janus.orderbook.execution;

/**
 * The interface Order.
 */
// https://github.com/bigfatwhale/orderbook/tree/master/rust/src
public interface IOrder {
    /**
     * Gets price.
     *
     * @return the price
     */
    long getPrice();

    /**
     * Gets side.
     *
     * @return the side
     */
    short getSide();

    /**
     * Gets volume.
     *
     * @return the volume
     */
    long getVolume();

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    void setVolume(long volume);

    /**
     * Gets order id.
     *
     * @return the order id
     */
    long getOrderID();
}
