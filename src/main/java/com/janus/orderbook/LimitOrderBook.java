package com.janus.orderbook;

import javafx.util.Pair;

import java.util.*;

public class LimitOrderBook implements ILimitOrderBook {
    private IOrderBook askBook;
    private IOrderBook bidBook;
    private Queue<IOrder> requests;


    @Override
    public void addOrder(IOrder order) {
        if (order.getSide() == -1) {
            // todo
        } else {
            // todo
        }
    }

    @Override
    public void removeOrder(IOrder order) {
        if (order.getSide() == -1) {
            this.askBook.removeOrder(order);
        } else {
            this.bidBook.removeOrder(order);
        }
    }

    interface check_and_do_cross_spread_walk_fun {
        boolean run(long a, long b);
    }

    static void check_and_do_cross_spread_walk(IOrder order, IOrderBook book, IOrderBook opp_book, check_and_do_cross_spread_walk_fun func) {
        if (opp_book.bestPrice() > 0 && func.run(order.getPrice(), opp_book.bestPrice())) {

        }
    }

    static Pair<Long, List<IOrder>> cross_spread_walk(IOrder order, IOrderBook B, check_and_do_cross_spread_walk_fun func) {
        long volume = order.getVolume();
        List<IOrder> orders_to_remove = new ArrayList<>();
        Iterator<IOrder> iterator = orders_to_remove.iterator();

        return new Pair(null, null);
    }

    public Set<Map.Entry<Long, IPriceBucket>> ask_iter() {
        return this.askBook.getPriceBuckets().entrySet();
    }

    public Set<Map.Entry<Long, IPriceBucket>> bid_iter() {
        return this.bidBook.getPriceBuckets().entrySet();
    }
}
