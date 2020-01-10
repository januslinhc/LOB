package com.janus.orderbook;

public class Order implements IOrder {
    private long order_id;
    private long price;
    private long volume;
    private short side;
    private String part_id;

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public short getSide() {
        return this.side;
    }

    @Override
    public long getVolume() {
        return this.volume;
    }
}
