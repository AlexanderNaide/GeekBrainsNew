package ru.gb.SpringContext.ClassWork;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemoryProductRepository implements ProductRepository{

    private List<Product> repository;

    @PostConstruct
    private void init(){
        repository = new ArrayList<>(Arrays.asList(
                new Product(1L, "Молоко"),
                new Product(2L, "Какао"),
                new Product(3L, "Кефир")
        ));
    }
    @Override
    public Product findById(final Long id){
        return repository.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

}
