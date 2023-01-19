package ru.gb.HomeWorks_core3.lesson7.HomeWork;

public class Cat {
    private String name;
    private String color;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat() {
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void catInfo(){
        System.out.printf(getCatInfo());
    }

    public String getCatInfo(){
        return String.format("This is a %s cat %s, he is %d years old.\n", color, name, age);
    }
}
