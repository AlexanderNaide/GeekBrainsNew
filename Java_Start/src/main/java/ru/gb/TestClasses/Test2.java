package ru.gb.TestClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        int n = 15;
        int[] arr = {3, 5, 7};

        Map<String, List<Integer>> map = new HashMap<>();
        map.put(String.valueOf(1), new ArrayList<>(List.of(1)));

        boolean finish = false;

        while (!finish){
            finish = true;
            Map<String, List<Integer>> newMap = new HashMap<>();
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                System.out.println("Взяли " + entry.getKey());
                for (int i : arr) {
                    if (entry.getValue().stream().reduce(0, Integer::sum) + i < 15 && !map.containsKey(entry.getKey() + i)){
                        System.out.println(entry.getKey() + i);
                        finish = false;
                        newMap.put(entry.getKey() + i, Stream.concat(entry.getValue().stream(), Stream.of(i)).toList());
                    }
                }
            }
            System.out.println("на выходе " + newMap.keySet());
            map.putAll(newMap);
        }

        System.out.println("!!! РЕШЕНИЕ: " + map.size());
        map.forEach((k, v) -> System.out.println(v));
    }
}
