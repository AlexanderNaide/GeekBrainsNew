package ru.gb.SpringContext.HomeWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> cartList;
    private ProductRepository productRepository;

    @PostConstruct
    public void init(){
        this.cartList = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getCart(){
        return cartList;
    }

    public void addProduct(Long id){
        cartList.add(productRepository.findById(id));
    }

    public void removeProduct(Long id){
        cartList.remove(productRepository.findById(id));
    }
}
