package ru.gb.HomeWorks_core2.lesson1;

public class Treadmill implements Barrier{

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
