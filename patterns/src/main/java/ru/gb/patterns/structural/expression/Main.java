package ru.gb.patterns.structural.expression;

public class Main {
    public static void main(String[] args) {

        Expression expression = new Multiply(
                new Summ(
                        new Const(2),
                        new Multiply(
                                new Const(3),
                                new Const(4)
                        )
                ),
                new Summ(new Const(5),
                        new Const(7)
                )
        );


        expression.print();
    }


}
