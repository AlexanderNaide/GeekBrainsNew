package ru.gb.HomeWork.Repository.Parents;

import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.User;

import java.util.List;

public interface ProductDao {

    void insert(Product product);

    Product get(Long id);

    void delete(Product product);

    List<Product> getAll();

    void save(Product product);

}
