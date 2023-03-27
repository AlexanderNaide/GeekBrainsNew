package ru.gb.patterns.structural.bridge;

public interface Paint {

    void fill(Shape shape);

    void stroke(Shape shape);

    void drawPoint(int x, int y);
}
