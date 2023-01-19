package ru.gb.spring_mvc.HomeWork_MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_mvc.model.Product;

@Controller
@RequestMapping("/product")
public class ProductsController {

    ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("products", repository.findAll());
        return "homework/products";
    }


    @GetMapping("/addPage")
    public String addPage() {
        return "homework/productCardNew";
    }

    @GetMapping("/{id}")
    public String product(Model model, @PathVariable Long id) {
        Product product = repository.findById(id);
        model.addAttribute("id", product.getId());
        model.addAttribute("title", product.getTitle());
        model.addAttribute("price", product.getCost());
        return "homework/productCard";
    }


    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(required = false) Long id,
                      @RequestParam String title,
                      @RequestParam String price
    ) {
        Product product;
        if (id == null) {
            product = new Product(title, Double.parseDouble(price.replace(",", ".")));
            repository.insert(product);
        } else {
            product = repository.findById(id);
            product.setTitle(title);
            product.setCost(Double.parseDouble(price.replace(",", ".")));
        }
        return product(model, product.getId());
    }
}
