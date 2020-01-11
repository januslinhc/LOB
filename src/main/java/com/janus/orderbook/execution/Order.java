package com.janus.orderbook.execution;

public class Order implements IOrder {
    private final long order_id;
    private final long price;
    private long volume;
    private final short side;
    private String part_id;

    public Order(long order_id, long price, long volume, short side, String part_id) {
        this.order_id = order_id;
        this.price = price;
        this.volume = volume;
        this.side = side;
        this.part_id = part_id;
    }

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

    @Override
    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public long getOrderID() {
        return this.order_id;
    }

    @Override
    public String toString() {
        return "order{" +
                "order_id=" + order_id +
                ", price=" + price +
                ", volume=" + volume +
                ", side=" + side +
                ", part_id='" + part_id + '\'' +
                '}';
    }
}
