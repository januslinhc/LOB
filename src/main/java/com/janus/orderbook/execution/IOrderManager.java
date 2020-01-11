package com.janus.orderbook.execution;

public interface IOrderManager {
    void addOrder(IOrder order);

    void removeOrder(IOrder order);
}
