package ru.gb.Bootcamp.Patterns.Visitor;

public abstract class Person {
    public String name;
    public String lastname;
    public abstract void Visit(PersonVisitor personVisitor);
}
