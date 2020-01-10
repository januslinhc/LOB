package com.janus.orderbook;

import java.util.Map;
import java.util.NavigableMap;

public abstract class OrderBook<K> implements IOrderBook {
    protected NavigableMap<Long, IPriceBucket> price_buckets;

    public long volume_at_price_level(long price) {
        IPriceBucket priceBucket = this.price_buckets.get(price);
        if (priceBucket != null) {
            return priceBucket.volume();
        }
        return 0;
    }

    @Override
    public void addOrder(IOrder order) {
        IPriceBucket priceBucket = this.price_buckets.get(order.getPrice());
        if (priceBucket != null) {
            priceBucket.addOrder(order);
        } else {
            long price = order.getPrice();
            IPriceBucket newPriceBucket = PriceBucket.fromOrder(order);
            this.price_buckets.put(price, newPriceBucket);
        }
    }

    @Override
    public void removeOrder(IOrder order) {
        this.price_buckets.remove(order);
    }

    @Override
    public NavigableMap<Long, IPriceBucket> getPriceBuckets() {
        return this.price_buckets;
    }
}
