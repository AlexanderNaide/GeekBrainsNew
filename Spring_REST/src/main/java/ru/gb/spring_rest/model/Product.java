package ru.gb.spring_rest.model;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "sub_category_1", nullable = false)
    @JsonView(View.Public.class)
    private String subCategory1;

    @Column(name = "sub_category_2")
    @JsonView(View.Public.class)
    private String subCategory2;

    @Column(name = "sub_category_3")
    private String subCategory3;

    @Column(name = "art", nullable = false)
    @JsonView(View.Public.class)
    private Long article;

    @Column(name = "modification")
    private String modification;

    @Column(name = "title")
    @JsonView(View.Public.class)
    private String title;

    @Column(name = "price")
    @JsonView(View.Public.class)
    private Double price;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "count")
    private Integer count;

    @Column(name = "manufacturer")
    @JsonView(View.Public.class)
    private String manufacturer;

    @Column(name = "description", length = 1200)
    @JsonView(View.ExtendedPublic.class)
    private String description;

}
