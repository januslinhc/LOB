package com.janus.orderbook.execution;

import java.util.Iterator;
import java.util.Map;

/**
 * The type Ask book.
 */
public class AskBook extends OrderBook<AskBook> {
    @Override
    public long getBestPrice() {
        if (this.price_buckets.size() > 0) {
            Map.Entry<Long, IPriceBucket> entry = this.price_buckets.lastEntry();
            if (entry != null) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Override
    public Iterator getIterMut() {
        return this.price_buckets.entrySet().iterator();
    }
}
