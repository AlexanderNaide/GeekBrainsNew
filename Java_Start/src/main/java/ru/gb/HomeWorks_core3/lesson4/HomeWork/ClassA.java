package ru.gb.HomeWorks_core3.lesson4.HomeWork;

public class ClassA implements Runnable {

    private final ClassCount classCount;

    public ClassA(ClassCount classCount) {
        this.classCount = classCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            classCount.printA();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
