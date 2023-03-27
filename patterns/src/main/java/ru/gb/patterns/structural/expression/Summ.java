package ru.gb.patterns.structural.expression;

public class Summ extends BinaryExpression {


    public Summ(Expression left, Expression right) {
        super(left, right, (l, r) -> l.eval() + r.eval());
    }

    @Override
    public String asString() {
        return String.format("(%s + %s)", getLeft().asString(), getRight().asString());
    }
}
