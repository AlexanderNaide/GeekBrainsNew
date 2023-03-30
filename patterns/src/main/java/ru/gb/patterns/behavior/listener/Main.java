package ru.gb.patterns.behavior.listener;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        EventPool eventPool = new EventPool();

        eventPool.registerListener(System.out::println);

        eventPool.start();

        while (in.hasNext()){
            String s = in.next();
            eventPool.publishEvent(new Event(s));
        }

    }

}
