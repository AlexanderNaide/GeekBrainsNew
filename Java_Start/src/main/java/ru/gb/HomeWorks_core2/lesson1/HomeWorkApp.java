package ru.gb.HomeWorks_core2.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {

        Run[] runnable = {
                new Human(2000, 1.2),
                new Cat(300, 2.2),
                new Robot(8000, 3.0)
        };

        Barrier[] barriers = {
                new Treadmill(500),
                new Wall(1.8)
        };

        for (Barrier barrier : barriers) {
            for (int j = 0; j < runnable.length; j++) {
                if (runnable[j] == null) {
                    continue;
                }
                if (barrier instanceof Treadmill){
                    if (!runnable[j].run((Treadmill) barrier)) runnable[j] = null;
                }
                if (barrier instanceof Wall){
                    if (!runnable[j].jump((Wall) barrier)) runnable[j] = null;
                }
            }
        }

        System.out.println();
        System.out.println("Состязания окончились, к финишу пришли:");
        for (Run run : runnable) {
            if (run != null) {
                System.out.println(run.getClass().getSimpleName());
            }
        }
    }
}
