package com.janus.orderbook.msg;

/**
 * The interface Trading status msg.
 */
public interface ITradingStatusMsg {

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets halt status.
     *
     * @return the halt status
     */
    char getHaltStatus();

    /**
     * Gets reg sho action.
     *
     * @return the reg sho action
     */
    char getRegShoAction();

    /**
     * Gets reserved 1.
     *
     * @return the reserved 1
     */
    char getReserved1();

    /**
     * Gets reserved 2.
     *
     * @return the reserved 2
     */
    char getReserved2();
}
