package ru.gb.spring_rest.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.spring_rest.model.Product;

public class ProductSpecifications {

    public static Specification<Product> priceGreaterOrEqualsThan(Double minPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessenOrEqualsThan(Double maxPrice){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

    public static Specification<Product> artLike(String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("article").as(String.class), String.format("%%%s%%", title));
    }

    public static Specification<Product> categories(String categories){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("subCategory1"), categories);
    }

    public static Specification<Product> subCategories(String subCategories){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("subCategory2"), subCategories);
    }

    public static Specification<Product> manufacturer(String man){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("manufacturer"), man);
    }

}
