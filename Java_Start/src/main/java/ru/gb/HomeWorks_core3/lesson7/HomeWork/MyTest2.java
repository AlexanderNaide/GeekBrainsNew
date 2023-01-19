package ru.gb.HomeWorks_core3.lesson7.HomeWork;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyTest2 {
    Cat cat;

    @BeforeSuite
    public void init(){
        cat = new Cat("CatName", "CatColor", 10);
        System.out.println("Test2 START");
    }

    @TestAnnotation
    public void consoleInfo(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream consoleStream = System.out;
        System.setOut(new PrintStream(output));
        String sample = "This is a CatColor cat CatName, he is 10 years old.\n";
        cat.catInfo();
        String result = output.toString();
        System.setOut(consoleStream);
        System.out.println("Test2 consoleInfo = " + sample.equals(result));
    }

    @TestAnnotation(priority = 2)
    public void returnInfo(){
        String sample = "This is a CatColor cat CatName, he is 10 years old.\n";
        System.out.println("Test2 returnInfo = " + sample.equals(cat.getCatInfo()));
    }

    @AfterSuite
    public static void end(){
        System.out.println("END");
    }

}
