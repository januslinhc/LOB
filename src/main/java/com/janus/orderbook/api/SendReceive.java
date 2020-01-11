package com.janus.orderbook.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SendReceive {
    //private static final Logger log = Logger.getLogger(SendReceive.class.toString());

    private final String host;
    private final int port;

    private Server server;

    public SendReceive(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.server = new Server(new ServerSocket(this.port));
            this.server.start();
        } catch (IOException ioe) {
            //this.log.log(Level.SEVERE, "IOException while creating server! - STOP", ioe);
        }
    }

    public String send(final String data) {
        Socket client = null;
        String response = null;

        try {
            client = new Socket(this.host, this.port);

            final OutputStream outToServer = client.getOutputStream();
            final DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(data);

            final InputStream inFromServer = client.getInputStream();
            final DataInputStream in = new DataInputStream(inFromServer);
            response = in.readUTF();
        } catch (final IOException e) {
            //this.log.log(Level.SEVERE, "Sending message to server " + this.host + ":" + this.port + " fail", e);
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (final IOException e) {
                    //this.log.log(Level.SEVERE, "Can't close socket connection to " + this.host + ":" + this.port, e);
                }
            }
        }
        if (response == null || response.isEmpty())
            return null;

        return response;
    }

    class Server extends Thread {
        private final ServerSocket serverSocket;

        public Server(ServerSocket s) {
            serverSocket = s;
        }

        @Override
        public void run() {
            Socket connection = null;
            //SendReceive.this.log.log(Level.INFO, "Server: DoubleEcho Server running on "+this.serverSocket.getLocalPort());
            try {
                do {
                    connection = this.serverSocket.accept();
                    //SendReceive.this.log.log(Level.INFO, "Server: new connection from "+connection.getRemoteSocketAddress());
                    int b;
                    do {
                        DataInputStream in = new DataInputStream(connection.getInputStream());
                        String s = in.readUTF();

                        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                        out.writeUTF(s + "," + s); // echo it back TWICE

                        out.flush();
                        connection.shutdownOutput();
                        connection.close();
                    } while (!connection.isClosed());
                }
                while (true);
            } catch (IOException ioe) {
                //SendReceive.this.log.log(Level.SEVERE, "IOException in server! - STOP", ioe);
            } finally {
                try {
                    this.serverSocket.close();
                } catch (Exception e) {
                    //SendReceive.this.log.log(Level.SEVERE, "IOException closing server! - FATAL", e);
                }
                try {
                    if (connection != null && !connection.isClosed())
                        connection.close();
                } catch (Exception e) {
                    //SendReceive.this.log.log(Level.SEVERE, "IOException closing server! - FATAL", e);
                }
            }
        }
    }
}
