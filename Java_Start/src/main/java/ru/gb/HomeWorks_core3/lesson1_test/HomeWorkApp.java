package ru.gb.HomeWorks_core3.lesson1_test;

public class HomeWorkApp {
    public static void main(String[] args) {


        /**
         * 3. Большая задача.
         */

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        System.out.println("Результат сравнения: " + appleBox.compare(orangeBox));
        System.out.println("В коробках по 1 фрукту, так как вес 1го фрукта разный, то и вес коробок должен быть разный, но получаем true");

    }
}
