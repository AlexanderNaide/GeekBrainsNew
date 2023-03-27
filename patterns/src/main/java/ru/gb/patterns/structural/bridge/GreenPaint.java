package ru.gb.patterns.structural.bridge;

import java.awt.*;

public class GreenPaint implements Paint{

    private Color color;

    public GreenPaint(Color color) {
        this.color = color;
    }

    @Override
    public void fill(Shape shape) {
        // fill shape
    }

    @Override
    public void stroke(Shape shape) {
        // stroke shape
    }

    @Override
    public void drawPoint(int x, int y) {

    }
}
