package ru.gb.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        TreeDecorator decorator = new BallsTreeDecorator(tree);

        decorator.decorate();

    }
}
