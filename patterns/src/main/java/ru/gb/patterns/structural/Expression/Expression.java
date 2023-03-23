package ru.gb.patterns.structural.Expression;

public interface Expression {

    int eval();

    String asString();

    default void print(){
        System.out.println(asString() + " = " + eval());
    }
}
