package com.janus.orderbook;

import java.util.Map;

public class AskBook extends OrderBook<AskBook> {
    @Override
    public long bestPrice() {
        Map.Entry<Long, IPriceBucket> entry = this.price_buckets.firstEntry();
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
