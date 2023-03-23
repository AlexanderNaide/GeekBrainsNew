package ru.gb.patterns.structural.Expression;

public abstract class BinaryExpression implements Expression {

    private final Expression left, right;
    private final BinaryOperation operation;

    public BinaryExpression(Expression left, Expression right, BinaryOperation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public int eval() {
        return operation.apply(left, right);
    }


    /**
     *
     * ******   1:00:00   ******
     *
     */
}
