package ru.gb.spring_security_rest.model;

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

}
