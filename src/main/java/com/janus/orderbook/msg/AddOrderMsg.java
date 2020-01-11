package com.janus.orderbook.msg;

/**
 * The type Add order msg.
 */
public class AddOrderMsg extends BATSMessage<IAddOrderMsg> implements IAddOrderMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
    private char side;
    private long shares;
    private String symbol;
    private long price;
    private char display;
    private String partId;

    /**
     * Instantiates a new Add order msg.
     *
     * @param timestamp the timestamp
     * @param msgType   the msg type
     * @param orderId   the order id
     * @param side      the side
     * @param shares    the shares
     * @param symbol    the symbol
     * @param price     the price
     * @param display   the display
     * @param partId    the part id
     */
    public AddOrderMsg(long timestamp, char msgType, long orderId, char side, long shares, String symbol, long price, char display, String partId) {
        this.timestamp = timestamp;
        this.msgType = msgType;
        this.orderId = orderId;
        this.side = side;
        this.shares = shares;
        this.symbol = symbol;
        this.price = price;
        this.display = display;
        this.partId = partId;
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
    public char getDisplay() {
        return this.display;
    }

    @Override
    public String getPartId() {
        return this.partId;
    }

    /**
     * Parse msg add order msg.
     *
     * @param str the str
     * @return the add order msg
     */
    public static IAddOrderMsg parseMsg(String str) {
        long timestamp = Long.parseLong(str.substring(0, 8));
        char msgType = str.charAt(8);
        long orderId = Long.parseLong(str.substring(9, 21), 36);
        char side = str.charAt(21);
        long shares = Long.parseLong(str.substring(22, 28));
        String symbol = str.substring(28, 34).trim();
        long price = Long.parseLong(str.substring(34, 44));
        char display = str.charAt(44);
        String partId;

        if (str.length() > 48) {
            partId = str.substring(48, str.length() - 1);
        } else {
            partId = "";
        }

        return new AddOrderMsg(timestamp, msgType, orderId, side, shares, symbol, price, display, partId);
    }
}
