package ru.gb.patterns.structural.decorator;

public class TreeDecorator extends Tree {

    private Tree tree;

    public TreeDecorator(Tree tree) {
        this.tree = tree;
    }

    void decorate(){
        tree.decorate();
    }

}
