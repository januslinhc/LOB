package com.janus.orderbook;

import java.util.List;

public class PriceBucket implements IPriceBucket {
    private long price_level;
    private List<IOrder> orders;

    @Override
    public String fmt() {
        return String.format("PriceBucket {{ price_level: %s }}", this.price_level);
    }
}
