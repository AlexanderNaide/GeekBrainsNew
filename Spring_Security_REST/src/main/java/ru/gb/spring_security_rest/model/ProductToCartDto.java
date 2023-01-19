package ru.gb.spring_security_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductToCartDto {

    private Long id;

    private Long article;

    private String title;

    private Double price;

    private Integer count;


}
