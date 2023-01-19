package ru.gb.HomeWorks_core3.lesson7.HomeWork;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyTest {
    Cat cat;

    @BeforeSuite
//    @BeforeEach
    public void init(){
        cat = new Cat("CatName", "CatColor", 10);
        System.out.println("START");
    }

    @TestAnnotation
//    @Test
    public void consoleInfo(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream consoleStream = System.out;
        System.setOut(new PrintStream(output));
        String sample = "This is a CatColor cat CatName, he is 10 years old.\n";
        cat.catInfo();
        String result = output.toString();
        System.setOut(consoleStream);
        System.out.println("Test consoleInfo = " + sample.equals(result));
//        Assertions.assertEquals(sample, output.toString());
//        System.setOut(consoleStream);
    }

    @TestAnnotation(priority = 2)
//    @Test
    public void returnInfo(){
        String sample = "This is a CatColor cat CatName, he is 10 years old.\n";
        System.out.println("Test returnInfo = " + sample.equals(cat.getCatInfo()));
//        Assertions.assertEquals(sample, cat.getCatInfo());
    }

    @AfterSuite
//    @AfterAll
    public static void end(){
        System.out.println("END");
    }

}
