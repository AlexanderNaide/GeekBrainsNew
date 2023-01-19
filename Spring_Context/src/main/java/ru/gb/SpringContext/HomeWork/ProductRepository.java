package ru.gb.SpringContext.HomeWork;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> repository;

    @PostConstruct
    private void init(){
        repository = new ArrayList<>(Arrays.asList(
                new Product(1L, "Молоко", 67.00),
                new Product(2L, "Какао", 160.00),
                new Product(3L, "Кефир", 86.00),
                new Product(4L, "Зефир", 120.00),
                new Product(5L, "Мюсли", 60.00)
        ));
    }

    public Product findById(final Long id){
        return repository.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Product> findAll(){
        return repository;
    }

}
