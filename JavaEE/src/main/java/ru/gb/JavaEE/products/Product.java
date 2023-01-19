package ru.gb.JavaEE.products;

public class Product {
    private int id;
    private String title;
    private Double cost;

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product(int id, String title, Double cost) {
        this(title, cost);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
