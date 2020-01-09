package com.janus.orderbook;

public interface IOrderManager {
    void addOrder(IOrder order);

    void removeOrder(IOrder order);
}
