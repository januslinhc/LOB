package com.janus.orderbook.msg;

/**
 * The type Trade break msg.
 */
public class TradeBreakMsg extends BATSMessage<ITradeBreakMsg> implements ITradeBreakMsg {
    private long timestamp;
    private char msgType;
    private long execId;

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public char getMsgType() {
        return this.msgType;
    }

    @Override
    public long getExecId() {
        return this.execId;
    }
}
