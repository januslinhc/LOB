package com.janus.orderbook.msg;

import java.util.Optional;

/**
 * The type Bats msg factory.
 */
public class BATSMsgFactory implements IBATSMsgFactory {
    @Override
    public Optional<IBATSMessage> parse(String str) {
        char type = str.charAt(8);

        switch (type) {
            case 'A':
                return Optional.of((IBATSMessage) AddOrderMsg.parseMsg(str));

            case 'd':
                return Optional.of((IBATSMessage) AddOrderMsg.parseMsg(str));

            case 'J':
                return Optional.of((IBATSMessage) AuctionSummaryMsg.parseMsg(str));

            // case 'I':
            //     return Optional.of((IBATSMessage) AuctionUpdateMsg.parseMsg(str));

            case 'X':
                return Optional.of(OrderCancelMsg.parseMsg(str));

            case 'E':
                return Optional.of((IBATSMessage) OrderExecutedMsg.parseMsg(str));

            //case 'R':
            //    return Optional.of((IBATSMessage) RetailPriceImproveMsg.parseMsg(str));

            //case 'B':
            //    return Optional.of((IBATSMessage) TradeBreakMsg.parseMsg(str));

            case 'P':
                return Optional.of((IBATSMessage) TradeMsg.parseMsg(str));

            case 'r':
                return Optional.of((IBATSMessage) TradeMsg.parseMsg(str));

            //case 'H':
            //    return Optional.of((IBATSMessage) TradingStatusMsg.parseMsg(str));

        }

        return Optional.empty();
    }
}
