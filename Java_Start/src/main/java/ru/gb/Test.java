package ru.gb;


import java.io.File;

public class Test {
    public void main(String[] args) {

        Boolean b = new File("C:/Java/GeekBrains_HomeWork/src/main/java/ru/gb/TestClasses/Test.txt").mkdir();
        System.out.println(b);
        ggggg g = new ggggg();
        Thread thread = new Thread(g);

    }

    public class ggggg implements Runnable{

        @Override
        public void run() {

        }
    }
}
