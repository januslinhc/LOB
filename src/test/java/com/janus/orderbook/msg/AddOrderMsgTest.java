package com.janus.orderbook.msg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddOrderMsgTest {

    @Test
    public void parseMsg() {
        String msg = "28800011AAK27GA0000DTS000100SH    0000619200Y";
        IAddOrderMsg addOrderMsg = AddOrderMsg.parseMsg(msg);

        assertEquals(28800011, ((IBATSMessage)addOrderMsg).getTimeStamp());
        assertEquals('A', ((IBATSMessage)addOrderMsg).getMsgType());
        assertEquals(Long.parseLong("1389564350501069297"), addOrderMsg.getOrderId());
        assertEquals('S', addOrderMsg.getSide());
        assertEquals(100, addOrderMsg.getShares());
        assertEquals("SH", addOrderMsg.getSymbol());
        assertEquals(619200, addOrderMsg.getPrice());
        assertEquals('Y', addOrderMsg.getDisplay());
    }
}
