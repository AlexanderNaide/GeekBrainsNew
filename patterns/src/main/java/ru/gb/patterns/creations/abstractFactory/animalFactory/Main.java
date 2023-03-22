package ru.gb.patterns.creations.abstractFactory.animalFactory;

public class Main {

    private static void createAnimalAndSay(AnimalFactory factory){
        factory.getAnimal().say();
    }
    public static void main(String[] args) {

        createAnimalAndSay(new CatFactory());
        createAnimalAndSay(new DogFactory());

    }
}