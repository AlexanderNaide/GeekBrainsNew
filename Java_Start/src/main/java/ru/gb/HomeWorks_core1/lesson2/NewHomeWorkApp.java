package ru.gb.HomeWorks_core1.lesson2;

public class NewHomeWorkApp {
    public static void main(String[] args) {
        System.out.println(check1(6, 7));
        System.out.println(check1(2, 3));
        check2(-10);
        check2(0);
        check2(17);
        System.out.println(check3(6));
        System.out.println(check3(-1));
        System.out.println(check3(0));
        check4("****************", 4);
        System.out.println(check5(2019));
        System.out.println(check5(2020));
        System.out.println(check5(2021));
        System.out.println(check5(2022));
    }

    public static boolean check1(int a, int b) {
        return (a + b) > 10 && (a + b) <= 20;
    }

    public static void check2(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean check3(int a) {
        return a < 0;
    }

    public static void check4(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static boolean check5(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }
}
