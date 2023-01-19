package ru.gb.HomeWorks_core1.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(){
        int a = (int) ((Math.random() * 10) - (Math.random() * 10));
        int b = (int) ((Math.random() * 10) - (Math.random() * 10));
//        System.out.println("Сумма = " + (a + b));
        if ((a + b) < 0) System.out.println("Сумма отрицательная");
        else System.out.println("Сумма положительная");
    }
    public static void printColor(){
        int value = (int) ((Math.random() * 1000) - (Math.random() * 1000));
//        System.out.println("value = " + value);
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }
    public static void compareNumbers(){
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
//        System.out.println("a = " + a + "; b = " + b);
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
