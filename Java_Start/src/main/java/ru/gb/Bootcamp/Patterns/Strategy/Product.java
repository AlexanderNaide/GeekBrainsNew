package ru.gb.Bootcamp.Patterns.Strategy;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private long Id;
    private String name;
    private BigDecimal price;

    public Product(){
    }

    public Product(long id, String name, BigDecimal price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Id == product.Id && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, price);
    }
}
