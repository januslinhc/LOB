package com.janus.orderbook.execution;

import java.util.NavigableMap;

public interface IOrderBook extends IBestPrice, IOrderManager, IPriceBucketIter {
    NavigableMap<Long, IPriceBucket> getPriceBuckets();

    long getVolumeAtPriceLevel(long price);
}
