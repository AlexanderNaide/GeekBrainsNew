package ru.gb.HomeWorks_core2.lesson1;

public class Human implements Run{

    private int possibleDistance ;
    private double possibleBarrier;

    public Human(int distance, double barrier){
        possibleDistance = distance;
        possibleBarrier = barrier;
    }

    @Override
    public boolean jump(Wall wall) {
        if (possibleBarrier > wall.getBarrier()) {
            System.out.printf("Человек прыгнул на %s метра.\n", wall.getBarrier());
            return true;
        } else {
            System.out.printf("Человек не смог перепрыгнуть препятствие в %s метра и выбывавет из созтязания.\n", wall.getBarrier());
            return false;
        }
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (possibleDistance > treadmill.getDistance()) {
            System.out.printf("Человек пробежал %s метров.\n", treadmill.getDistance());
            return true;
        } else {
            System.out.printf("Человек не смог пробежать %s метров и выбывавет из созтязания.\n", treadmill.getDistance());
            return false;
        }
    }
}
