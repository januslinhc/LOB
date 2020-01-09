package com.janus.orderbook;

public class Order implements IOrder {
    private long order_id;
    private long price;
    private long volume;
    private short side;
    private String part_id;

    @Override
    public long bestPrice() {
        return 0;
    }

    @Override
    public void addOrder(IOrder order) {

    }

    @Override
    public void removeOrder(IOrder order) {

    }
}
