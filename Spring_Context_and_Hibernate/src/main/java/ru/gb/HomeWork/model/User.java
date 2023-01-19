package ru.gb.HomeWork.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany (mappedBy = "buyer")
    private List<TheBuy> buyList;

//    @ManyToMany
//    @JoinTable(
//            name = "purchase",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> productsList;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.buyList = new ArrayList<>();
    }

    public User(Long id, String name) {
        this(name);
        this.name = name;
    }

    public User(Long id, String name, List<TheBuy> buyList) {
        this(id, name);
        this.buyList = buyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TheBuy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<TheBuy> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
