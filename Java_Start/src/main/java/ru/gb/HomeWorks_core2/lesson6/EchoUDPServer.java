package ru.gb.HomeWorks_core2.lesson6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class EchoUDPServer {

    private static final int PORT = 6830;

    public static void main(String[] args) {
        new EchoUDPServer().start();
    }

    private void start() {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buf = new byte[512];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String income = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + income);

                if (income.equals("/end")) {
                    break;
                }

                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                byte[] answer = ("ECHO: " + income).getBytes(StandardCharsets.UTF_8);
                packet = new DatagramPacket(answer, answer.length, address, port);

                socket.send(packet);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
