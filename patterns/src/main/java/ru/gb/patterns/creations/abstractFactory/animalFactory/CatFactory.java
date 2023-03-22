package ru.gb.patterns.creations.abstractFactory.animalFactory;

import ru.gb.patterns.creations.abstractFactory.animalFactory.madel.Animal;
import ru.gb.patterns.creations.abstractFactory.animalFactory.madel.Cat;

public class CatFactory extends AnimalFactory {

    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
