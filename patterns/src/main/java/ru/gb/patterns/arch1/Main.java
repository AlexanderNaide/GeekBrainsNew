package ru.gb.patterns.arch1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> p1 = new Pair<>(1, 2);
        Pair<Integer, Integer> p2 = new Pair<>(1, 2);

        Map <Pair<Integer, Integer>, Integer> map = new HashMap<>();

        map.put(p1, 1);
        map.put(p2, 1);

        System.out.println(map.size());


    }
}
