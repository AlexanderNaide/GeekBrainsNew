package ru.gb.HomeWorks_core3.lesson4.HomeWork;

public class ClassCount {
    private int count = 0;

    public synchronized void printA(){
        while (count % 3 != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        count++;
        System.out.print("A");
        notifyAll();
    }

    public synchronized void printB(){
        while (count % 3 != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        count++;
        System.out.print("B");
        notifyAll();
    }

    public synchronized void printC(){
        while (count % 3 != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        count++;
        System.out.print("C ");
        notifyAll();
    }
}
