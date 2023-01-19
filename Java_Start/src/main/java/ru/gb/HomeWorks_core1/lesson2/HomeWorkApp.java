package ru.gb.HomeWorks_core1.lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(exam1(1, 2));
        print1(0);
        System.out.println(exam2(0));
        print2("Я пишу на Java!", 5);
        System.out.println(exam3(2000));
        System.out.println(exam3(2100));
    }
    // Задание 1: если сумма от 10 до 20 (вкл.) то true, во всех остальных false.
    public static boolean exam1 (int a, int b){
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    // Задание 2: если число < 0 вывести "Отрицательное", если 0 и выше - вывести "Положительные".
    public static void print1 (int a) {
        System.out.println(a < 0 ? "Отрицательное" : "Положительное");
    }

    // Задание 3: если число < 0 вернуть true, если 0 и выше - вернуть false.
    public static boolean exam2 (int a) {
        return a < 0;
    }

    // Задание 4: вывести строку n число раз.
    public static void print2 (String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    //Задание 5: вернуть true, если год высокосный.
    public static boolean exam3 (int g){
        if (g % 400 == 0) {        // каждый 400й - высокосный
            return true;
        }
        else if (g % 100 == 0) {   // из оставшихся каждый 100й невысокосный
            return false;
        }
        else {                     // из всех прочих высокосный только каждый 4й
            return g % 4 == 0;
        }
    }
}
