package ru.gb.Bootcamp.Patterns.Visitor;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person){
        persons.add(person);
    }

    public void Accept(PersonVisitor personVisitor){
        for (Person person : persons) {
            person.Visit(personVisitor);
        }
    }

}
