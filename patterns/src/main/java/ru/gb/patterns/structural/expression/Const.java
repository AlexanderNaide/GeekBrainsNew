package ru.gb.patterns.structural.expression;

public class Const implements Expression {

    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
