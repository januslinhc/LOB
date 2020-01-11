package com.janus.orderbook.execution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NavigableMap;
import java.util.TreeMap;

public abstract class OrderBook<K> implements IOrderBook {
    protected NavigableMap<Long, IPriceBucket> price_buckets;
    private static final Logger LOGGER = LogManager.getLogger(OrderBook.class);

    public OrderBook() {
        this.price_buckets = new TreeMap<>();
    }

    @Override
    public long getVolumeAtPriceLevel(long price) {
        IPriceBucket priceBucket = this.price_buckets.get(price);
        if (priceBucket != null) {
            return priceBucket.getVolume();
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
        IPriceBucket priceBucket = this.price_buckets.get(order.getPrice());
        LOGGER.debug(String.format("deleting request %s", order));

        if (priceBucket != null) {
            priceBucket.removeOrder(order);
            LOGGER.info(String.format("complete request %s", order));
        }
    }

    @Override
    public NavigableMap<Long, IPriceBucket> getPriceBuckets() {
        return this.price_buckets;
    }
}
