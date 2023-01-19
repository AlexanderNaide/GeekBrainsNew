package ru.gb.SpringContext.ClassWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component (value = "ps")
public class ProductService {

//    @Autowired
    private ProductRepository productRepository;

    @Autowired
//    public void setProductRepository(@Qualifier("inMemoryProductRepository") ProductRepository productRepository) {
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id){
        return productRepository.findById(id).getTitle();
    }
}
