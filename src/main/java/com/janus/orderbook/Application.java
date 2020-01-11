package com.janus.orderbook;

import com.janus.orderbook.api.Server;
import com.janus.orderbook.execution.ILimitOrderBook;
import com.janus.orderbook.execution.LimitOrderBook;
import com.janus.orderbook.marketFeed.FeedServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Application.
 */
public class Application implements IApplication {
    private static IApplication instance;
    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    private ILimitOrderBook limitOrderBook;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    private Application() {
        this.start();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static IApplication getInstance() {
        if (instance == null) {
            instance = new Application();
        }

        return instance;
    }

    @Override
    public void start() {
        this.limitOrderBook = new LimitOrderBook();
        executorService.submit(() -> {
            try {
                Server.start(getOrderBook());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                FeedServer.start(getOrderBook());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public ILimitOrderBook getOrderBook() {
        return this.limitOrderBook;
    }
}
