package ru.gb.HomeWorks_core3.lesson4.HomeWork;

public class ClassC implements Runnable {

    private final ClassCount classCount;

    public ClassC(ClassCount classCount) {
        this.classCount = classCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            classCount.printC();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
