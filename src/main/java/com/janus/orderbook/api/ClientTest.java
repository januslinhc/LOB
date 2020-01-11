package com.janus.orderbook.api;

import java.util.concurrent.ThreadLocalRandom;

public class ClientTest {
    public static void main(String[] args) throws InterruptedException {
        SendReceive sr = new SendReceive("localhost", 5056);
        String res;
        String msg;
        for (int i = 0; i < 100; i++) {
            char side;
            if (random(1, 10) > 5) {
                side = 'B';
            } else {
                side = 'S';
            }
            int[] sharesList = {100, 200, 300, 400};
            int shares = sharesList[random(0, 3)];
            int price = random(40, 70);
            msg = genReq(20200111, 0, side, shares, "JAN", price, 'Y', null);
            System.out.println(msg);
            res = sr.send(msg);
            System.out.println(res);

            Thread.sleep(400);
        }
    }

    static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    static String genReq(long timestamp, long orderId, char side, long shares, String symbol, long price, char display, String partId) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%08d", timestamp));
        builder.append('A');
        builder.append("9K27G60000SY");
        builder.append(side);
        builder.append(String.format("%06d", shares));
        builder.append(padLeftZeros(symbol, 6));
        builder.append(String.format("%010d", price));
        builder.append(display);
        builder.append("");
        return builder.toString();
    }

    static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
