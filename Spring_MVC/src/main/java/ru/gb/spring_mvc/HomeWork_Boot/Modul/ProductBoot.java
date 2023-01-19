package ru.gb.spring_mvc.HomeWork_Boot.Modul;

public class ProductBoot {

    private static Long counter = 1L;
    private final Long id;
    private String title;
    private Double price;

    public ProductBoot() {
        this.id = counter++;
    }

    public ProductBoot(String title) {
        this();
        this.title = title;
    }

    public ProductBoot(String title, Double price) {
        this(title);
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
