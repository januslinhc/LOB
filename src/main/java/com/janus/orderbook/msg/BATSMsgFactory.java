package com.janus.orderbook.msg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

/**
 * The type Bats msg factory.
 */
public class BATSMsgFactory implements IBATSMsgFactory {
    private static final Logger LOGGER = LogManager.getLogger(BATSMsgFactory.class);

    public static Optional<IBATSMessage> parse(String str) {
        char type = str.charAt(8);

        try {
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
        } catch (Exception e) {
            // nothing to so
            LOGGER.error(e);
        }

        return Optional.empty();
    }
}
