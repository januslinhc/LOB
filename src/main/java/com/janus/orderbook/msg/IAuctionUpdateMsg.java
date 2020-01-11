package com.janus.orderbook.msg;

/**
 * The interface Auction update msg.
 */
public interface IAuctionUpdateMsg {
    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    long getTimestamp();

    /**
     * Gets msg type.
     *
     * @return the msg type
     */
    char getMsgType();

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets auction type.
     *
     * @return the auction type
     */
    char getAuctionType();

    /**
     * Gets reference price.
     *
     * @return the reference price
     */
    long getReferencePrice();

    /**
     * Gets buy shares.
     *
     * @return the buy shares
     */
    long getBuyShares();

    /**
     * Gets sell shares.
     *
     * @return the sell shares
     */
    long getSellShares();

    /**
     * Gets indicative price.
     *
     * @return the indicative price
     */
    long getIndicativePrice();

    /**
     * Gets auction only price.
     *
     * @return the auction only price
     */
    long getAuctionOnlyPrice();
}
