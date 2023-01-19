package ru.gb.Bootcamp.Patterns.Visitor;

public class Teacher extends Person{
    public int totalGroup;

    @Override
    public void Visit(PersonVisitor personVisitor) {
        personVisitor.showInfoPerson(this);
    }
}
