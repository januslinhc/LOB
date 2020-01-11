package com.janus.orderbook.msg;

/**
 * The type Order executed msg.
 */
public class OrderExecutedMsg extends BATSMessage<IOrderExecutedMsg> implements IOrderExecutedMsg {
    private long timestamp;
    private char msgType;
    private long orderId;
    private long shares;
    private long execId;

    /**
     * Instantiates a new Order executed msg.
     *
     * @param timestamp the timestamp
     * @param msgType   the msg type
     * @param orderId   the order id
     * @param shares    the shares
     * @param execId    the exec id
     */
    public OrderExecutedMsg(long timestamp, char msgType, long orderId, long shares, long execId) {
        this.timestamp = timestamp;
        this.msgType = msgType;
        this.orderId = orderId;
        this.shares = shares;
        this.execId = execId;
    }

    /**
     * Parse msg order executed msg.
     *
     * @param str the str
     * @return the order executed msg
     */
    public static IOrderExecutedMsg parseMsg(String str) {
        long timestamp = Long.parseLong(str.substring(0, 8));
        char msgType = str.charAt(8);
        long orderId = Long.parseLong(str.substring(9, 21), 36);
        long shares = Long.parseLong(str.substring(21, 27));
        long execId = Long.parseLong(str.substring(27, 39), 36);

        return new OrderExecutedMsg(timestamp, msgType, orderId, shares, execId);
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
    public long getShares() {
        return this.shares;
    }

    @Override
    public long getExecId() {
        return this.execId;
    }
}
