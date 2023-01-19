package ru.gb.Bootcamp.Patterns.Factory;

/**
 *
 * Фабрика продовольственных магазинов
 */

public class GroceryStoreFactory implements StoreFactory{
    @Override
    public Store createStore() {
        return new GroceryStore();
    }
}
