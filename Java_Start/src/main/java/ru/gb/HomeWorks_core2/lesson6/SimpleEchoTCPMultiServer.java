package ru.gb.HomeWorks_core2.lesson6;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleEchoTCPMultiServer {
    private static final int PORT = 6830;
    private static int COUNT = 1;

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (true) {
                ClientForMultiServer client = new ClientForMultiServer(serverSocket.accept(), COUNT);
                COUNT++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
