package ru.gb.spring_security_rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_security_rest.converters.ProductConverter;
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
@RequestMapping("api/v1/cart")
public class CartController {
    private final ProductConverter productConverter;
    private final CartService cartService;


    @GetMapping("/add_to_cart")
    public void addToCart(@RequestParam Long id, @RequestParam(required = false, defaultValue = "1") Integer count){
        cartService.addProduct(id, count);
    }

    @GetMapping("/dell_from_cart")
    public void dellFromCart(@RequestParam Long id){
        cartService.dellProduct(id);
    }

    @GetMapping
    public List<ProductToCartDto> getMapCart(){
//        return cartService.getMapCart().entrySet().stream().collect(Collectors.toList((entry) -> productConverter.entityToDto(entry.getKey()), Map.Entry::getValue));
        return cartService.getMapCart().entrySet().stream()
                .map(entry -> productConverter.entityToCardDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
