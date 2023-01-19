package ru.gb.spring_security_rest.model;

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

}