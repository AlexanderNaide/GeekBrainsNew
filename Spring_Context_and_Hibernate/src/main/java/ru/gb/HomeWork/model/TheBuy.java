package ru.gb.HomeWork.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Entity
@Table(name = "buys")
public class TheBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @ManyToMany
    @JoinTable(
            name = "purchase",
            joinColumns = @JoinColumn(name = "buy_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productsList;

    public TheBuy() {
    }

    public TheBuy(User buyer) {
        this.buyer = buyer;
        this.productsList = new ArrayList<>();
    }

    public TheBuy(User buyer, List<Product> productsList) {
        this.buyer = buyer;
        this.productsList = productsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "TheBuy{" +
                "buyer=" + buyer +
                ", createDate=" + createDate +
                ", productsList=" + productsList +
                '}';
    }
}
