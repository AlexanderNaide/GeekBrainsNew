package ru.gb.HomeWorks_core3.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static volatile CyclicBarrier cyclicBarrierStart;
    public static volatile CountDownLatch countStart;
    public static volatile CountDownLatch countFinish;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        cyclicBarrierStart = new CyclicBarrier(MainClass.CARS_COUNT);
        countStart = new CountDownLatch(MainClass.CARS_COUNT);
        countFinish = new CountDownLatch(MainClass.CARS_COUNT);
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countStart.countDown();
            cyclicBarrierStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (MainClass.winner == null){
            MainClass.winner = this;
            System.out.println(name + " - WIN");
        }
        countFinish.countDown();
    }
}
