package ru.gb.Bootcamp.Algorithms.Armstrong;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Logger {

    private final Date startDate = new Date();
    public static boolean show = false;
    private final Map<Integer, Long> results = new TreeMap<>();

    public void log(int value){
        results.putIfAbsent(value, new Date().getTime() - startDate.getTime());
    }
    public void print(){
        if (show){
            for (Map.Entry<Integer, Long> integerLongEntry : results.entrySet()) {
                System.out.println((integerLongEntry.getValue()) + " found armstrong number: " + integerLongEntry.getKey());
            }
        }
    }
}
