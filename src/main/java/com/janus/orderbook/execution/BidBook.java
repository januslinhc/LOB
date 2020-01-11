package com.janus.orderbook.execution;

import java.util.Iterator;
import java.util.Map;

public class BidBook extends OrderBook<BidBook> {
    @Override
    public long getBestPrice() {
        if (this.price_buckets.size() > 0) {
            Map.Entry<Long, IPriceBucket> entry = this.price_buckets.firstEntry();
            if (entry != null) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Override
    public Iterator getIterMut() {
        return this.price_buckets.descendingMap().entrySet().iterator();
    }
}
