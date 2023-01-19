package ru.gb.SpringContext.ClassWork;

import org.springframework.stereotype.Component;

@Component
public interface ProductRepository {

    Product findById(Long id);
}
