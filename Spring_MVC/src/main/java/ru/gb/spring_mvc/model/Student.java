package ru.gb.spring_mvc.model;

public class Student {

    private static Long counter = 1L;
    private final Long id;
    private String name;

    private Integer score;

    public Student() {
        this.id = counter++;
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public Student(String name, Integer score) {
        this(name);
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
