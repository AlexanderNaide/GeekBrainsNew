package ru.gb.HomeWorks_core3.lesson4.HomeWork;

public class HomeWorkApp {

    public static void main(String[] args) {

        ClassCount count = new ClassCount();

        ClassA classA = new ClassA(count);
        ClassB classB = new ClassB(count);
        ClassC classC = new ClassC(count);

        new Thread(classA).start();
        new Thread(classB).start();
        new Thread(classC).start();


    }
}
