package ru.gb.patterns.creations.factoryMethod.pair;

public class Main {

    public static void main(String[] args) {

        Pair<String, Integer> pair = Pair.of("Hello", 2);
        String left = pair.getLeft();
        Integer right = pair.getRight();

    }
}