package ru.gb.HomeWorks_core2.lesson1;

public class Robot implements Run{

    private int possibleDistance ;
    private double possibleBarrier;

    public Robot(int distance, double barrier){
        possibleDistance = distance;
        possibleBarrier = barrier;
    }

    @Override
    public boolean jump(Wall wall) {
        if (possibleBarrier > wall.getBarrier()) {
            System.out.printf("Робот прыгнул на %s метра.\n", wall.getBarrier());
            return true;
        } else {
            System.out.printf("Робот не смог перепрыгнуть препятствие в %s метра и выбывавет из созтязания.\n", wall.getBarrier());
            return false;
        }
    }


    @Override
    public boolean run(Treadmill treadmill) {
        if (possibleDistance > treadmill.getDistance()) {
            System.out.printf("Робот пробежал %s метров.\n", treadmill.getDistance());
            return true;
        } else {
            System.out.printf("Робот не смог пробежать %s метров и выбывавет из созтязания.\n", treadmill.getDistance());
            return false;
        }
    }
}
