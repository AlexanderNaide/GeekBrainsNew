package ru.gb.spring_rest2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //конструктор без аргументов для Джексона
@AllArgsConstructor //конструктор со всеми аргументами
public class ProductDto {

    private Long id;

    private Long article;

    private String title;

    private Double price;

/*    public ProductDto(Product product) {
        this.id = product.getId();
        this.article = product.getArticle();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }*/
}
