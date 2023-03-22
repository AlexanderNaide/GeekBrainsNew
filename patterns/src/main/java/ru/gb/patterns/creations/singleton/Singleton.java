package ru.gb.patterns.creations.singleton;

public class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton(){
        System.out.println(this);
    }

    public static Singleton getInstance(){
        if (INSTANCE == null){
            synchronized (Singleton.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public void printHello(){
        System.out.println("Hello " + this);
    }

}
