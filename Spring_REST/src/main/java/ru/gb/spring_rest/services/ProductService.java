package ru.gb.spring_rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.repository.ProductRepository;
import ru.gb.spring_rest.repository.specifications.ProductSpecifications;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setCategoryRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> findCom(Double minPrice, Double maxPrice, String title, String categories, String subCategories, String man, Integer page){

        Specification<Product> spec = Specification.where(null);

        if(minPrice != null){
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecifications.priceLessenOrEqualsThan(maxPrice));
        }
        if(title != null){
            spec = spec.and(ProductSpecifications.titleLike(title)).or(ProductSpecifications.artLike(title));
        }

        if(categories != null){
            spec = spec.and(ProductSpecifications.categories(categories));
        }

        if(subCategories != null){
            spec = spec.and(ProductSpecifications.subCategories(subCategories));
        }

        if(man != null){
            spec = spec.and(ProductSpecifications.manufacturer(man));
        }

        return productRepository.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public List<String> findAllCategories() {
        return productRepository.findAllCategories();
    }

    public List<String> findAllSubCategories(String cat) {
        return productRepository.findAllSubCategories(cat);
    }

    public List<String> findManufacturer(String categories, String subCategories){
        if(categories == null){
            categories = "%";
        }
        if (subCategories == null){
            subCategories = "%";
        }
        return productRepository.findManufacturer(categories, subCategories);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
