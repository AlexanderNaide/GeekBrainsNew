package ru.gb.patterns.creations.factory;

import ru.gb.patterns.creations.factory.madel.Animal;
import ru.gb.patterns.creations.factory.madel.Dog;

public class DogFactory extends AnimalFactory {

    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
