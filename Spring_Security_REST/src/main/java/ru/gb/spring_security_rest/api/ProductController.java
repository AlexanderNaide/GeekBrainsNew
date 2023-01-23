package ru.gb.spring_security_rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_security_rest.converters.ProductConverter;
import ru.gb.spring_security_rest.exceptions.AppError;
import ru.gb.spring_security_rest.exceptions.ResourceNotFoundException;
import ru.gb.spring_security_rest.model.ProductDto;
import ru.gb.spring_security_rest.model.ProductFullDto;
import ru.gb.spring_security_rest.model.ProductToCartDto;
import ru.gb.spring_security_rest.services.CartService;
import ru.gb.spring_security_rest.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor // Ломбоковская аннотация, которая инициализирует final поля вместо конструктора с @Autowired
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping("/{id}")
    public ProductFullDto getProductById(@PathVariable Long id){
//        return new ProductFullDto(productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
//        return productService.findById(id).map(ProductFullDto::new).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return productService.findById(id).map(productConverter::entityToFullDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return productService.findById(id).map(productConverter::entityToFullDto).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден в базе данных товаров, id:" + id));
    }

    @PostMapping
    public Page<ProductDto> upAll(@RequestParam(required = false, defaultValue = "1") Integer page,
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
        return productService.findCom(min, max, val, cat, sub_cat, man, page).map(productConverter::entityToDto);
    }

    @GetMapping
    public Page<ProductDto> findAll(){
        return productService.findCom(null, null, null, null, null, null,1).map(productConverter::entityToDto);
    }

    @GetMapping("/categories")
    public List<String> getCategories(){
        return productService.findAllCategories();
    }

    @GetMapping("/sub_categories")
    public List<String> getSubCategories(@RequestParam(required = false) String cat){
        return productService.findAllSubCategories(cat);
    }

    @GetMapping("/man")
    public List<String> getManufacturer(
            @RequestParam(required = false) String cat,
            @RequestParam(required = false) String sub_cat
    ){
        return productService.findManufacturer(cat, sub_cat);
    }
}
