package com.janus.orderbook.msg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderExecutedMsgTest {

    @Test
    void parseMsg() {
        String msg = "28950519E4K27GA0000K000010000004AQ0000D";
        IOrderExecutedMsg orderExecutedMsg = OrderExecutedMsg.parseMsg(msg);

        assertEquals(Long.parseLong("28950519"), orderExecutedMsg.getTimestamp());
        assertEquals('E', orderExecutedMsg.getMsgType());
        assertEquals(Long.parseLong("4K27GA0000K0", 36), orderExecutedMsg.getOrderId());
        assertEquals(Long.parseLong("000100"), orderExecutedMsg.getShares());
        assertEquals(Long.parseLong("00004AQ0000D", 36), orderExecutedMsg.getExecId());
    }
}
