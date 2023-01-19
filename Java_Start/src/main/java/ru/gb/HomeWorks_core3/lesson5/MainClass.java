package ru.gb.HomeWorks_core3.lesson5;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static Car winner = null;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            Car.countStart.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            Car.countFinish.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("--- ОБЬЯВЛЕНИЕ ПОБЕДИТЕЛЯ ---");
        System.out.println("Победителем стал: " + winner.getName());
        System.out.println("Рекордная скорость трассы: " + winner.getSpeed() + "км/ч.");
    }

}
