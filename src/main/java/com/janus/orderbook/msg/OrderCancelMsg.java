package com.janus.orderbook.msg;

/**
 * The type Order cancel msg.
 */
public class OrderCancelMsg extends BATSMessage<IOrderCancelMsg> implements IOrderCancelMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
    private long shares;

    /**
     * Instantiates a new Order cancel msg.
     *
     * @param timestamp the timestamp
     * @param msgType   the msg type
     * @param orderId   the order id
     * @param shares    the shares
     */
    public OrderCancelMsg(long timestamp, char msgType, long orderId, long shares) {
        this.timestamp = timestamp;
        this.msgType = msgType;
        this.orderId = orderId;
        this.shares = shares;
    }

    /**
     * Parse msg order cancel msg.
     *
     * @param str the str
     * @return the order cancel msg
     */
    public static OrderCancelMsg parseMsg(String str) {
        long timestamp = Long.parseLong(str.substring(0, 8));
        char msgType = str.charAt(8);
        long orderId = Long.parseLong(str.substring(9, 21), 36);
        long shares = Long.parseLong(str.substring(21, 27));

        return new OrderCancelMsg(timestamp, msgType, orderId, shares);
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
    public long getShares() {
        return this.shares;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }
}
