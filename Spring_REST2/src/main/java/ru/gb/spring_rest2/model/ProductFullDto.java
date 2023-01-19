package ru.gb.spring_rest2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //конструктор без аргументов для Джексона
@AllArgsConstructor //конструктор со всеми аргументами
public class ProductFullDto {

    private Long id;

    private String subCategory1;

    private String subCategory2;

    private Long article;

    private String title;

    private Double price;

    private String manufacturer;

    private String description;

/*    public ProductFullDto(Product product) {
        this.id = product.getId();
        this.subCategory1 = product.getSubCategory1();
        this.subCategory2 = product.getSubCategory2();
        this.article = product.getArticle();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.description = product.getDescription();
    }*/
}
