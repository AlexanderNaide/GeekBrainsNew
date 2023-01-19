package ru.gb.HomeWorks_core3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private final ArrayList<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void addFruit(T t) {
        list.add(t);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public Float getWeight() {
        if (list.size() > 0){
            return list.get(0).getWeightFruit() * list.size();
        } else {
            return 0.0f;
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        if (box == null){
            return false;
        }
        if (this.list.size() == 0){
            return box.getList().size() == 0;
        }
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void pourOver(Box<T> box){
        box.getList().addAll(list);
        list.clear();
    }
}
