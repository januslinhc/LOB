package com.janus.orderbook;

import java.util.NavigableMap;

public interface IOrderBook extends IBestPrice, IOrderManager, IPriceBucketIter {
    NavigableMap<Long, IPriceBucket> getPriceBuckets();
}
