package ru.gb.patterns.structural.bridge;

import java.awt.*;

public abstract class Shape {

    private final Paint paint;

    protected Shape(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public void fill(){
        getPaint().fill(this);
    }

}
