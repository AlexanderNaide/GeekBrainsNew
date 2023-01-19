package ru.gb.HomeWorks_core2.lesson3;

import java.util.*;

public class HomeWorkApp {
    public static void main(String[] args) {


        /************    Задание 1    ************/

        List<String> list = new ArrayList<>();

        list.add("January");
        list.add("February");
        list.add("March");
        list.add("February");
        list.add(3, "April");
        list.set(4, "May");
        list.addAll(Arrays.asList("June", "July", "May", "August", "September", "May", "October", "April"));
        list.addAll(List.of("November", "December"));

        Map<String, Integer> map = new LinkedHashMap<>();
        list.forEach(s -> {
            if (map.containsKey(s)) map.put(s, map.get(s)+1);
            else map.put(s, 1);
        });

        System.out.println(list);

        map.forEach((s, count) -> System.out.println(s + " (" + count + ")"));


        /************    Задание 2    ************/
        System.out.println();

        TelephoneDirectory directory = new TelephoneDirectory();

        directory.add("Иванов", "+7 999 777 32 40");
        directory.add("Грибанов Серый", "+7 908 320 16 10");
        directory.add("Иванов", "+7 919 465 21 42");
        directory.add("Самойлов Глеб", "+7 999 777 88 88");
        directory.add("Иванов", "+7 920 324 51 59");

        System.out.println();

        directory.get("Самойлов Глеб");
        directory.get("Иванов");
        directory.get("Приют для котиков");
    }
}
