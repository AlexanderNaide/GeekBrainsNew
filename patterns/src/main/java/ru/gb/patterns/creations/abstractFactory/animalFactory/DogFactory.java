package ru.gb.patterns.creations.abstractFactory.animalFactory;

import ru.gb.patterns.creations.abstractFactory.animalFactory.madel.Animal;
import ru.gb.patterns.creations.abstractFactory.animalFactory.madel.Dog;

public class DogFactory extends AnimalFactory {

    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
