package ru.gb.HomeWorks_core1.lesson6;

public class Cat extends Animal{

    protected static int count;
    private final int limitRun = 200;

    public Cat(String name){
        this.name = name;
        count++;
    }

    public void run(int meter){
        if (meter > limitRun) {
            meter = limitRun;
        }
        super.run(meter);
    }
    public void swing(int meter){
        System.out.println("Правильные котики не плавают. И не просите.");
    }
}
