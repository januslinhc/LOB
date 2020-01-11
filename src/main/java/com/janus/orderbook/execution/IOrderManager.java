package com.janus.orderbook.execution;

/**
 * The interface Order manager.
 */
public interface IOrderManager {
    /**
     * Add order.
     *
     * @param order the order
     */
    void addOrder(IOrder order);

    /**
     * Remove order.
     *
     * @param order the order
     */
    void removeOrder(IOrder order);
}
