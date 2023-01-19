package ru.gb.spring_rest2.converters;

import org.springframework.stereotype.Component;
import ru.gb.spring_rest2.model.Product;
import ru.gb.spring_rest2.model.ProductDto;
import ru.gb.spring_rest2.model.ProductFullDto;
import ru.gb.spring_rest2.model.ProductToCartDto;

@Component
public class ProductConverter {

/*    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), null, null, null, null, productDto.getArticle(), null, productDto.getTitle(), productDto.getPrice(), null, null, null, null, null);
    }*/

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getArticle(), product.getTitle(), product.getPrice());
    }

    public ProductToCartDto entityToCardDto(Product product, Integer count){
        return new ProductToCartDto(product.getId(), product.getArticle(), product.getTitle(), product.getPrice(), count);
    }

    public ProductFullDto entityToFullDto(Product product){
        return new ProductFullDto(product.getId(), product.getSubCategory1(), product.getSubCategory2(), product.getArticle(), product.getTitle(), product.getPrice(), product.getManufacturer(), product.getDescription());
    }

}
