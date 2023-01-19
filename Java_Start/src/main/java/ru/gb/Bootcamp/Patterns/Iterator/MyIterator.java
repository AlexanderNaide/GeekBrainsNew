package ru.gb.Bootcamp.Patterns.Iterator;

/**
 * Пользовательский Итератор (В системе есть встроенный Iterator с базовой реализацией,
 * поэтому, чтобы не путать - обзываем MyIterator)
 */

public interface MyIterator {

    boolean hasNext();
    Object next();
    int getIteratorPosition();
    Object getItem();
    Object getIdItem(int id);
    boolean removeItem(int id);
}
