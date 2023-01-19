package ru.gb.HomeWorks_core2.lesson3;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

    private final Map<String, String> directory;

    public TelephoneDirectory(){
        directory = new HashMap<>();
    }

    public void add(String name, String phone){
        directory.put(phone, name);
    }

    public void get(String name){
        System.out.println(name + ": ");
        if (!directory.containsValue(name)){
            System.out.println("Номер телефона не найден.");
        } else {
            directory.forEach((s, s2) -> {
                if (s2.equals(name)){
                    System.out.println(s);
                }
            });
        }
    }

    public void printDirectory(){
        directory.forEach((s, s2) -> System.out.println(s2 + " " + s));
    }

}
