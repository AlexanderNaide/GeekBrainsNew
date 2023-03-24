package ru.gb.patterns.structural.decorator;

public class BallsTreeDecorator extends TreeDecorator {


    public BallsTreeDecorator(Tree tree) {
        super(tree);
    }

    @Override
    void decorate() {
        super.decorate();
        ballsDecorate();
    }

    private void ballsDecorate(){
        System.out.print("decorate with balls ");
    }
}
