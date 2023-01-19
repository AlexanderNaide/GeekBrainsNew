package ru.gb.HomeWorks_core2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SuperSimpleConsoleTCPClient {
    private static final int PORT = 6830;
    private static final String HOST = "127.0.0.1"; //"localhost"

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             Scanner scanner = new Scanner(System.in)) {


            System.out.println("Connected to server");

            var in = new DataInputStream(socket.getInputStream());
            var out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String outcome = scanner.nextLine();
                out.writeUTF(outcome);
                Thread.sleep(50);
                String income = in.readUTF();
                System.out.println("Got the answer: " + income);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
