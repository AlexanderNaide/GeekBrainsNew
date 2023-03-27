package ru.gb.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {

        LongGetter getter = new LongGetter(){};

        LongGetter proxy = new LongGetterCashed(getter);

        for (int i = 0; i < 5; i++) {
            System.out.println(proxy.getLong(100));
        }
    }
}
