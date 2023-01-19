package ru.gb.HomeWorks_core2.lesson6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimpleUDPClient {

    private static final int PORT = 6830;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        new SimpleUDPClient().start();
    }

    private void start() {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buf;
            InetAddress address = InetAddress.getByName(HOST);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String outcome = scanner.nextLine();
                buf = outcome.getBytes(StandardCharsets.UTF_8);
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
                socket.send(packet);
                Thread.sleep(50);
                byte[] receiveBuf = new byte[buf.length + 6];
                packet = new DatagramPacket(receiveBuf, receiveBuf.length);
                socket.receive(packet);
                String income = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Got the answer: " + income);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
