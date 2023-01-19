package ru.gb.spring_rest.api;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.spring_rest.model.Product;
import ru.gb.spring_rest.model.View;
import ru.gb.spring_rest.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @JsonView(View.ExtendedPublic.class)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @JsonView(View.Public.class)
    public Page<Product> upAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false) String val,
                               @RequestParam(required = false) Double min,
                               @RequestParam(required = false) Double max,
                               @RequestParam(required = false) String cat,
                               @RequestParam(required = false) String man,
                               @RequestParam(required = false) String sub_cat
                               ){
        if(page < 1){
            page = 1;
        }
        return productService.findCom(min, max, val, cat, sub_cat, man, page);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public Page<Product> findAll(){
        return productService.findCom(null, null, null, null, null, null,1);
    }

    @GetMapping("/categories")
    public List<String> getCategories(){
        return productService.findAllCategories();
    }

    @PostMapping("/sub_categories")
    public List<String> getSubCategories(@RequestParam(required = false) String cat){
        return productService.findAllSubCategories(cat);
    }

    @PostMapping("/man")
    public List<String> getManufacturer(
            @RequestParam(required = false) String cat,
            @RequestParam(required = false) String sub_cat
    ){
        return productService.findManufacturer(cat, sub_cat);
    }
}
