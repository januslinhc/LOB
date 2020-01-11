package com.janus.orderbook.api;

import com.janus.orderbook.execution.ILimitOrderBook;
import com.janus.orderbook.msg.BATSMsgFactory;
import com.janus.orderbook.msg.IBATSMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ClientHandler.class);
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    final ILimitOrderBook book;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, ILimitOrderBook book) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.book = book;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        Optional<IBATSMessage> msg;

        while (this.s.isConnected()) {
            try {
                received = dis.readUTF();
                LOGGER.debug(String.format("received: %s", received));

                if (received.equals("Q")) {
                    this.s.close();
                    break;
                }

                msg = BATSMsgFactory.parse(received);
                if (msg.isPresent()) {
                    //LOGGER.debug("valid!");
                    RequestHandler.submit(book, msg.get());
                    dos.writeUTF("1");
                }
            } catch (EOFException e) {
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
