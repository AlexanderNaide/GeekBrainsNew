package ru.gb.HomeWorks_core3.lesson4.HomeWork;

public class ClassB implements Runnable {

    private final ClassCount classCount;

    public ClassB(ClassCount classCount) {
        this.classCount = classCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            classCount.printB();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
