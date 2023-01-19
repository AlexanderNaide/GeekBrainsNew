package ru.gb.spring_mvc.HomeWork_Boot.Repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.spring_mvc.HomeWork_Boot.Modul.ProductBoot;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryBoot {
    private final List<ProductBoot> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        addProduct(new ProductBoot("Молоко", 67.99));
        addProduct(new ProductBoot("Колбаса \"Докторская\"", 339.99));
        addProduct(new ProductBoot("Томаты \"Черри\"", 320.00));
        addProduct(new ProductBoot("Marshmello", 130.00));
        addProduct(new ProductBoot("Котлеты \"Веганские\"", 229.99));
        addProduct(new ProductBoot("Кефир", 87.99));
        addProduct(new ProductBoot("Огурцы", 240.30));
        addProduct(new ProductBoot("Молоко \"Немолоко\"", 88.00));
        addProduct(new ProductBoot("Шоколад \"Аленка\"", 59.99));
        addProduct(new ProductBoot("Крекер \"Рыбкины хвостики\"", 99.99));
    }

    public void addProduct(ProductBoot productBoot){
        list.add(productBoot);
    }

    public ProductBoot findById(final Long ig){
        return list.stream().filter(s -> s.getId().equals(ig)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<ProductBoot> getAllProduct(){
        return list;
    }

    public void deleteById(Long id){
        list.removeIf(s -> s.getId().equals(id));
    }
}
