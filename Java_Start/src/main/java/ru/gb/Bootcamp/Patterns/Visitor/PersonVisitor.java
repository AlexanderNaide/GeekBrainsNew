package ru.gb.Bootcamp.Patterns.Visitor;

public abstract class PersonVisitor {

    public abstract void showInfoPerson(Student student);
    public abstract void showInfoPerson(Teacher teacher);
}
