package ru.gb;

import ru.gb.patterns.creations.factory.AnimalFactory;
import ru.gb.patterns.creations.factory.CatFactory;
import ru.gb.patterns.creations.factory.DogFactory;

public class Main {

    private static void createAnimalAndSay(AnimalFactory factory){
        factory.getAnimal().say();
    }
    public static void main(String[] args) {

        createAnimalAndSay(new CatFactory());
        createAnimalAndSay(new DogFactory());

    }
}