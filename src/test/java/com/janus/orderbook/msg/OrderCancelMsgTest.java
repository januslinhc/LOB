package com.janus.orderbook.msg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderCancelMsgTest {

    @Test
    void parseMsg() {
        String msg = "28963591X1K27GA0000D1002000";
        IOrderCancelMsg orderCancelMsg = OrderCancelMsg.parseMsg(msg);

        assertEquals(Long.parseLong("28963591"), ((IBATSMessage)orderCancelMsg).getTimeStamp());
        assertEquals('X', ((IBATSMessage)orderCancelMsg).getMsgType());
        assertEquals(Long.parseLong("204969015920665045"), orderCancelMsg.getOrderId());
        assertEquals(Long.parseLong("2000"), orderCancelMsg.getShares());
    }
}
