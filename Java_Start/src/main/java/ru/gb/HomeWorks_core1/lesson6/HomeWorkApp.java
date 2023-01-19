package ru.gb.HomeWorks_core1.lesson6;

public class HomeWorkApp {

    public static void main(String[] args) {

        Dog bobik = new Dog("Бобик");

        bobik.run(150);
        bobik.swing(8);

        Cat barsik = new Cat("Барсик");

        barsik.run(100);
        barsik.swing(50);

        Dog sharik = new Dog("Шарик");

        sharik.run(600);
        sharik.swing(20);

        System.out.println("Итого создано животных: " + Animal.count + ", из них собак: " + Dog.count + " и котов: " + Cat.count);

    }
}
