package ru.gb.patterns.creations.singleton;

public class Main {

    private static void foo(){
        Singleton.getInstance().printHello();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(Main::foo).start();
        }
    }
}
