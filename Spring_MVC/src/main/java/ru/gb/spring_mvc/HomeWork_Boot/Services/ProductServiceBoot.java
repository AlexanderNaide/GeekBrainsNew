package ru.gb.spring_mvc.HomeWork_Boot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_mvc.HomeWork_Boot.Modul.ProductBoot;
import ru.gb.spring_mvc.HomeWork_Boot.Repositories.ProductRepositoryBoot;


import java.util.List;

@Service
public class ProductServiceBoot {

    private ProductRepositoryBoot repository;

    @Autowired
    public void setRepository(ProductRepositoryBoot repository) {
        this.repository = repository;
    }

    public List<ProductBoot> getAllProduct(){
        return repository.getAllProduct();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void addProduct(ProductBoot productBoot){
        repository.addProduct(productBoot);
    }

}
