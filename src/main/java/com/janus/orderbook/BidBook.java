package com.janus.orderbook;

import java.util.Map;

public class BidBook extends OrderBook<BidBook> {
    @Override
    public long bestPrice() {
        Map.Entry<Long, IPriceBucket> entry = this.price_buckets.lastEntry();
        if (entry != null) {
            return entry.getKey();
        }
        return 0;
    }

    @Override
    public IterVariant iterMut() {
        return null;
    }
}
