package ru.gb.spring_mvc.HomeWork_Boot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_mvc.HomeWork_Boot.Modul.ProductBoot;
import ru.gb.spring_mvc.HomeWork_Boot.Services.ProductServiceBoot;


import java.util.List;

@RestController                                                    // - Эта аннотация означает, что ВСЕ методы в этом контроллере будут @ResponseBody без явного указания самого @ResponseBody
public class ProductControllerBoot {

    private ProductServiceBoot service;

    @Autowired
    public void setService(ProductServiceBoot service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<ProductBoot> getAllProducts(){
        return service.getAllProduct();
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PostMapping("/add-product")
    public void addProductForm(@RequestBody ProductBoot product){
        service.addProduct(product);
    }
}
