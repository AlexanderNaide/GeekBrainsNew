package ru.gb.spring_boot_and_hibernate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.spring_boot_and_hibernate.model.Customer;
import ru.gb.spring_boot_and_hibernate.model.Product;
import ru.gb.spring_boot_and_hibernate.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }

    @PostMapping
    public List<Product> upAll(@RequestParam(required = false, defaultValue = "") String val,
                               @RequestParam(required = false, defaultValue = "0.0") Double min,
                               @RequestParam(required = false, defaultValue = "-1.0") Double max){
        return productService.findAllSorted(val, min, max);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id){
        productService.deleteById(id);
    }
}
