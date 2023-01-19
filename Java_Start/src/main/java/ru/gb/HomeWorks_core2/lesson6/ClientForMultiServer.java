package ru.gb.HomeWorks_core2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientForMultiServer extends Thread {
    private final Socket socket;
    private final int clientCount;

    public ClientForMultiServer(Socket socket, int count) {
        this.socket = socket;
        this.clientCount = count;
        this.start();
        System.out.println("Client #" + clientCount + " connected.");
    }

    @Override
    public void run() {
        try {
            var in = new DataInputStream(socket.getInputStream());
            var out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String income = "ECHO: " + in.readUTF();
                System.out.println("Received for client #" + clientCount + ": " + income);
                Thread.sleep(50);
                out.writeUTF(income);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
