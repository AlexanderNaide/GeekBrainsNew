package ru.gb.Bootcamp.Patterns.Command;

/**
 * Музыкальный центр
 */

public class MusicBox {

    public void turnOn(){
        System.out.println("The music box is ON.");
    }

    public void turnOff(){
        System.out.println("The music box is OFF.");
    }

    public void makeLoud(){
        System.out.println("Sound is loud!");
    }
}
