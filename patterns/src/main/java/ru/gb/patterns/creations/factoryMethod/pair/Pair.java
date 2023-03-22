package ru.gb.patterns.creations.factoryMethod.pair;

public class Pair<L, R> {

    public static <L, R> Pair<L, R> of(L left, R right){
        return new Pair<>(left, right);
    }

    private final L left;
    private final R right;

    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
