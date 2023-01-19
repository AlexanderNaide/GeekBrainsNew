package ru.gb.Bootcamp.Patterns.Factory;

/**
 * Фабрика магазинов одежды
 */

public class WearStoreFactory implements StoreFactory{
    @Override
    public Store createStore() {
        return new WearStore();
    }
}
