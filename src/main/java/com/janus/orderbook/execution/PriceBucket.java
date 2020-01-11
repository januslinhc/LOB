package com.janus.orderbook.execution;

import java.util.*;

public class PriceBucket implements IPriceBucket {
    private final long price_level;
    private final List<IOrder> orders;

    public PriceBucket(long price_level, List<IOrder> orders) {
        this.price_level = price_level;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("PriceBucket {{ price_level: %s }}", this.price_level);
    }

    @Override
    public void addOrder(IOrder order) {
        this.orders.add(order);
    }

    @Override
    public void removeOrder(IOrder order) {
        this.orders.remove(order);
    }

    public static IPriceBucket fromPrice(long price_level) {
        return new PriceBucket(price_level, new ArrayList<>());
    }

    public static IPriceBucket fromOrder(IOrder order) {
        return new PriceBucket(order.getPrice(), new ArrayList<>(Arrays.asList(order)));
    }

    @Override
    public long getVolume() {
        Optional<Long> result = this.orders.stream().map(order -> order.getVolume()).reduce((aLong, aLong2) -> aLong + aLong2);
        if (result.isPresent()) {
            return result.get();
        }
        return 0;
    }

    @Override
    public long getPriceLevel() {
        return this.price_level;
    }

    @Override
    public Iterator getOrdersIter() {
        return this.orders.iterator();
    }
}
