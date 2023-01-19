package ru.gb.SpringContext.ClassWork;

public class Product {
    private final Long id;
    private String title;

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
}
