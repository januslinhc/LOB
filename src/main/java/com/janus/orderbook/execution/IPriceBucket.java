package com.janus.orderbook.execution;

import java.util.Iterator;

/**
 * The interface Price bucket.
 */
public interface IPriceBucket extends IOrderManager {
    /**
     * Gets volume.
     *
     * @return the volume
     */
    long getVolume();

    /**
     * Gets price level.
     *
     * @return the price level
     */
    long getPriceLevel();

    /**
     * Gets orders iter.
     *
     * @return the orders iter
     */
    Iterator getOrdersIter();
}
