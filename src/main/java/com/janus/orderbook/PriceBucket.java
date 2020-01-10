package com.janus.orderbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriceBucket implements IPriceBucket {
    private long price_level;
    private List<IOrder> orders;

    public PriceBucket(long price_level, List<IOrder> orders) {
        this.price_level = price_level;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("PriceBucket {{ price_level: %s }}", this.price_level);
    }

    @Override
    public long volume() {
        //this.orders.stream().map(order -> order).sum
        return 0;
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
}
