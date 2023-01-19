package ru.gb.HomeWorks_core3.lesson7;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;

    public String info() {
        return name;
    }

    public String info(String str) {
        return super.toString() + " " + str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }
}
