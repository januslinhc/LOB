package com.janus.orderbook.msg;

/**
 * The type Auction summary msg.
 */
public class AuctionSummaryMsg extends BATSMessage<IAuctionSummaryMsg> implements IAuctionSummaryMsg {
    private long timestamp;
    private char msgType;
    private String symbol;
    private char auctionType;
    private long price;
    private long shares;

    /**
     * Instantiates a new Auction summary msg.
     *
     * @param timestamp   the timestamp
     * @param msgType     the msg type
     * @param symbol      the symbol
     * @param auctionType the auction type
     * @param price       the price
     * @param shares      the shares
     */
    public AuctionSummaryMsg(long timestamp, char msgType, String symbol, char auctionType, long price, long shares) {
        this.timestamp = timestamp;
        this.msgType = msgType;
        this.symbol = symbol;
        this.auctionType = auctionType;
        this.price = price;
        this.shares = shares;
    }

    /**
     * Parse msg auction summary msg.
     *
     * @param str the str
     * @return the auction summary msg
     */
    public static IAuctionSummaryMsg parseMsg(String str) {
        long timestamp = Long.parseLong(str.substring(0, 8));
        char msgType = str.charAt(8);
        String symbol = str.substring(9, 17).trim();
        char auctionType = str.charAt(17);
        long price = Long.parseLong(str.substring(18, 28));
        long shares = Long.parseLong(str.substring(28, 38));

        return new AuctionSummaryMsg(timestamp, msgType, symbol, auctionType, price, shares);
    }

    @Override
    public char getMsgType() {
        return this.msgType;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public char getAuctionType() {
        return this.auctionType;
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public long getShares() {
        return this.shares;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }
}
