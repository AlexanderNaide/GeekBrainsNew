package ru.gb.Bootcamp.Patterns.Factory;
 /**
 * Продовольственный магазин
 */

public class GroceryStore implements Store{
    @Override
    public void saleGood() {
        System.out.println("Вкусная еда.");
    }
 }
