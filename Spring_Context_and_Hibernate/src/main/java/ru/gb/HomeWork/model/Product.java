package ru.gb.HomeWork.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User userId;

    @ManyToMany
    @JoinTable(
            name = "purchase",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buy_id")
    )
    private List<User> usersList;

    public Product() {
    }

    public Product(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public Product(Long id, String title, Double price) {
        this(title, price);
        this.id = id;
    }

/*    public Product(Long id, String title, Double price, List<User> usersList) {
        this(id, title, price);
        this.usersList = usersList;
    }*/

    public Product(Long id, String title, Double price, List<User> usersList) {
        this(id, title, price);
        this.usersList = usersList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

/*    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }*/

        public List<User> getUsers() {
        return usersList;
    }

    public void setUsers(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Product{" +
//                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
