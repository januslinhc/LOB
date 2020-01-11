package com.janus.orderbook.execution;

public class Application implements IApplication {
    private static IApplication instance;

    private ILimitOrderBook limitOrderBook;

    private Application() {
        this.start();
    }

    public static IApplication getInstance() {
        if (instance == null) {
            instance = new Application();
        }

        return instance;
    }

    @Override
    public void start() {
        //PropertiesConfigurator is used to configure logger from properties file

        this.limitOrderBook = new LimitOrderBook();
    }

    @Override
    public ILimitOrderBook getOrderBook() {
        return this.limitOrderBook;
    }
}