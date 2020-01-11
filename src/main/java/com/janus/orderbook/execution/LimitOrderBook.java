package com.janus.orderbook.execution;

import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Limit order book.
 */
public class LimitOrderBook implements ILimitOrderBook {
    private volatile IOrderBook askBook;
    private volatile IOrderBook bidBook;
    private volatile Queue<IOrder> askRequests;
    private volatile Queue<IOrder> bidRequests;
    private final ExecutorService executorService;
    private static final Logger LOGGER = LogManager.getLogger(LimitOrderBook.class);

    /**
     * Instantiates a new Limit order book.
     */
    public LimitOrderBook() {
        this.askBook = new AskBook();
        this.bidBook = new BidBook();
        this.askRequests = new ConcurrentLinkedDeque<>();
        this.bidRequests = new ConcurrentLinkedDeque<>();
        this.executorService = Executors.newFixedThreadPool(2);
        //this.start_workers();
    }

    /**
     * Cross spread walk pair.
     *
     * @param order the order
     * @param book  the book
     * @param func  the func
     * @return the pair
     */
    static Pair<Long, List<IOrder>> crossSpreadWalk(IOrder order, IOrderBook book, check_and_do_cross_spread_walk_fun func) {
        long volume = order.getVolume();
        List<IOrder> orders_to_remove = new ArrayList<>();

        Iterator<Map.Entry<Long, IPriceBucket>> iterator = book.getIterMut();
        Map.Entry<Long, IPriceBucket> obj;
        IOrder objIterOrder;
        Iterator<IOrder> objIter;
        while (iterator.hasNext()) {
            obj = iterator.next();
            objIter = obj.getValue().getOrdersIter();

            while (objIter.hasNext()) {
                objIterOrder = objIter.next();
                if (!(volume > 0 && func.run(order.getPrice(), objIterOrder.getPrice()))) {
                    break;
                }

                if (volume >= objIterOrder.getVolume()) {
                    volume -= objIterOrder.getVolume();
                    LOGGER.debug(String.format("taking %s from order id %s, left %s", objIterOrder.getVolume(), objIterOrder.getOrderID(), volume));
                    objIterOrder.setVolume(0);

                    orders_to_remove.add(objIterOrder);
                } else {
                    objIterOrder.setVolume(objIterOrder.getVolume() - volume);
                    volume = 0;
                    LOGGER.debug(String.format("taking %s from order id %s, left %s", objIterOrder.getVolume(), objIterOrder.getOrderID(), volume));
                }
            }
        }

        return new Pair(volume, orders_to_remove);
    }

    @Override
    public void removeOrder(IOrder order) {
        if (order.getSide() == -1) {
            this.askBook.removeOrder(order);
        } else {
            this.bidBook.removeOrder(order);
        }
    }


    @Override
    public void startWorkers() {
        this.executorService.submit(() -> {
            while (true) {
                if (this.askRequests.size() > 0) {
                    IOrder order = this.askRequests.peek();
                    this.checkAndDoCrossSpreadWwalk(order, this.askBook, this.bidBook, (x, y) -> x <= y);
                    this.askRequests.poll();
                }

                Thread.sleep(50);
            }
        });

        this.executorService.submit(() -> {
            while (true) {
                if (this.bidRequests.size() > 0) {
                    IOrder order = this.bidRequests.peek();
                    this.checkAndDoCrossSpreadWwalk(order, this.bidBook, this.askBook, (x, y) -> x >= y);
                    this.bidRequests.poll();
                }

                Thread.sleep(50);
            }
        });
    }

    @Override
    public void addRequest(IOrder order) {
        LOGGER.info(String.format("add request %s", order));
        //this.requests.add(order);
        this.addOrder(order);
    }

    @Override
    public long getBestBid() {
        return this.bidBook.getBestPrice();
    }

    @Override
    public long getBestAsk() {
        return this.askBook.getBestPrice();
    }

    @Override
    public long getAskVolumeAtPriceLevel(long price) {
        IPriceBucket priceBucket = this.askBook.getPriceBuckets().get(price);
        if (priceBucket != null) {
            return priceBucket.getVolume();
        }
        return 0;
    }

    @Override
    public long getBidVolumeAtPriceLevel(long price) {
        IPriceBucket priceBucket = this.bidBook.getPriceBuckets().get(price);
        if (priceBucket != null) {
            return priceBucket.getVolume();
        }
        return 0;
    }

    @Override
    public void shutdown() {
        this.executorService.shutdown();
    }

    @Override
    public void addOrder(IOrder order) {
        // -1 is ask / buy
        // 0 is bid / sell
        if (order.getSide() == -1) {
            this.checkAndDoCrossSpreadWwalk(order, this.askBook, this.bidBook, (x, y) -> x <= y);
            //this.askRequests.add(order);
        } else {
            this.checkAndDoCrossSpreadWwalk(order, this.bidBook, this.askBook, (x, y) -> x >= y);
            //this.bidRequests.add(order);
        }
    }

    private void checkAndDoCrossSpreadWwalk(IOrder order, IOrderBook book, IOrderBook opp_book, check_and_do_cross_spread_walk_fun func) {
        if (opp_book.getBestPrice() > 0 && func.run(order.getPrice(), opp_book.getBestPrice())) {
            Pair<Long, List<IOrder>> result = crossSpreadWalk(order, opp_book, func);
            order.setVolume(result.getKey());

            for (IOrder orderToRemove : result.getValue()) {
                this.removeOrder(orderToRemove);
            }
        }

        if (order.getVolume() > 0) {
            LOGGER.debug(String.format("add order %s to order book", order));
            book.addOrder(order);
        }
    }

    /**
     * Ask iter set.
     *
     * @return the set
     */
    public Set<Map.Entry<Long, IPriceBucket>> ask_iter() {
        return this.askBook.getPriceBuckets().entrySet();
    }

    /**
     * Bid iter set.
     *
     * @return the set
     */
    public Set<Map.Entry<Long, IPriceBucket>> bid_iter() {
        return this.bidBook.getPriceBuckets().entrySet();
    }

    /**
     * The interface Check and do cross spread walk fun.
     */
    interface check_and_do_cross_spread_walk_fun {
        /**
         * Run boolean.
         *
         * @param a the a
         * @param b the b
         * @return the boolean
         */
        boolean run(long a, long b);
    }
}
