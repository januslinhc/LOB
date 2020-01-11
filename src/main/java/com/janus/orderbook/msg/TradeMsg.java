package com.janus.orderbook.msg;

/**
 * The type Trade msg.
 */
public class TradeMsg extends BATSMessage<ITradeMsg> implements ITradeMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
    private char side;
    private long shares;
    private String symbol;
    private long price;
    private long execId;

    /**
     * Instantiates a new Trade msg.
     *
     * @param timestamp the timestamp
     * @param msgType   the msg type
     * @param orderId   the order id
     * @param side      the side
     * @param shares    the shares
     * @param symbol    the symbol
     * @param price     the price
     * @param execId    the exec id
     */
    public TradeMsg(long timestamp, char msgType, long orderId, char side, long shares, String symbol, long price, long execId) {
        this.timestamp = timestamp;
        this.msgType = msgType;
        this.orderId = orderId;
        this.side = side;
        this.shares = shares;
        this.symbol = symbol;
        this.price = price;
        this.execId = execId;
    }

    /**
     * Parse msg trade msg.
     *
     * @param str the str
     * @return the trade msg
     */
    public static ITradeMsg parseMsg(String str) {
        long timestamp = Long.parseLong(str.substring(0, 8));
        char msgType = str.charAt(8);
        long orderId = Long.parseLong(str.substring(9, 21), 36);
        char side = str.charAt(21);
        long shares = Long.parseLong(str.substring(22, 28));
        String symbol;
        long price;
        long execId;
        if (msgType == 'P') {
            symbol = str.substring(28, 34).trim();
            price = Long.parseLong(str.substring(34, 44));
            execId = Long.parseLong(str.substring(44, 56), 36);
        } else {
            symbol = str.substring(28, 36).trim();
            price = Long.parseLong(str.substring(36, 46));
            execId = Long.parseLong(str.substring(46, 58), 36);
        }

        return new TradeMsg(timestamp, msgType, orderId, side, shares, symbol, price, execId);
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public char getMsgType() {
        return this.msgType;
    }

    @Override
    public long getOrderId() {
        return this.orderId;
    }

    @Override
    public char getSide() {
        return this.side;
    }

    @Override
    public long getShares() {
        return this.shares;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public long getExecId() {
        return this.execId;
    }
}
