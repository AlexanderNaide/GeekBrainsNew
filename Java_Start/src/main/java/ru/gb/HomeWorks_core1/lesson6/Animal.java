package ru.gb.HomeWorks_core1.lesson6;

public abstract class Animal {

    protected static int count;

    protected String name;

    public Animal(){
        count++;
    }

    public void run(int meter){
        System.out.printf("%s пробежал %d м.\n", name, meter);
    }
    public void swing(int meter){
        System.out.printf("%s проплыл %d м.\n", name, meter);
    }

}
