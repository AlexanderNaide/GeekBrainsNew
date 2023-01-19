package ru.gb.Bootcamp.Patterns.Observer;

public class Person implements Subscriber{

    public int Id;

    public String name;

    @Override
    public void Notification(Document document) {
        System.out.printf("%s : %s.\n", name, document.getBody());
    }
}
