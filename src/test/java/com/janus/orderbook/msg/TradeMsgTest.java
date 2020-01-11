package com.janus.orderbook.msg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeMsgTest {

    @Test
    void parseMsg() {
        String msg = "28946142P9K27G60000SYB000400PTR   0001430000000I000HV2OK";
        ITradeMsg tradeMsg = TradeMsg.parseMsg(msg);

        assertEquals(Long.parseLong("28946142"), tradeMsg.getTimestamp());
        assertEquals('P', tradeMsg.getMsgType());
        assertEquals(Long.parseLong("9K27G60000SY", 36), tradeMsg.getOrderId());
        assertEquals('B', tradeMsg.getSide());
        assertEquals(Long.parseLong("000400"), tradeMsg.getShares());
        assertEquals("PTR", tradeMsg.getSymbol());
        assertEquals(Long.parseLong("0001430000"), tradeMsg.getPrice());
        assertEquals(Long.parseLong("000I000HV2OK", 36), tradeMsg.getExecId());
    }
}
