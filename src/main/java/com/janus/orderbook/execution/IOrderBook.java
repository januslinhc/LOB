package com.janus.orderbook.execution;

import java.util.NavigableMap;

/**
 * The interface Order book.
 */
public interface IOrderBook extends IBestPrice, IOrderManager, IPriceBucketIter {
    /**
     * Gets price buckets.
     *
     * @return the price buckets
     */
    NavigableMap<Long, IPriceBucket> getPriceBuckets();

    /**
     * Gets volume at price level.
     *
     * @param price the price
     * @return the volume at price level
     */
    long getVolumeAtPriceLevel(long price);
}
