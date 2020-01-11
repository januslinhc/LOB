package com.janus.orderbook.execution;

import java.util.Iterator;

public interface IPriceBucket extends IOrderManager {
    long getVolume();

    long getPriceLevel();

    Iterator getOrdersIter();
}
