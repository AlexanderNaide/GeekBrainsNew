package ru.gb.HomeWorks_core3.lesson7.HomeWork;

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat catMurzik = new Cat("Murzik", "red", 8);
        catMurzik.catInfo();

        System.out.println("\n-------- Запуск через класс -------");

        RunTests.start(MyTest.class);
        RunTests.start(MyTest2.class);

        System.out.println("\n--------Запуск через название класса -------");

        RunTests.start("MyTest");
        RunTests.start("MyTest2");

    }
}
