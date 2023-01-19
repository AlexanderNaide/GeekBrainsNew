package ru.gb.spring_mvc.HomeWork_MVC;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.spring_mvc.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductRepository {

    private final Map<Long, Product> map = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    public Product findById(Long id) {
        return map.get(id);
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        map.put(id, product);
    }

    public void update(Product product) {
        map.put(product.getId(), product);
    }

    public void delete(long id) {
        map.remove(id);
    }

    @PostConstruct
    public void init() {
        insert(new Product("Молоко", 67.99));
        insert(new Product("Колбаса \"Докторская\"", 339.99));
        insert(new Product("Томаты \"Черри\"", 320.00));
        insert(new Product("Marshmello", 130.00));
        insert(new Product("Котлеты \"Веганские\"", 229.99));
        insert(new Product("Кефир", 87.99));
        insert(new Product("Огурцы", 240.30));
        insert(new Product("Молоко \"Немолоко\"", 88.00));
        insert(new Product("Шоколад \"Аленка\"", 59.99));
        insert(new Product("Крекер \"Рыбкины хвостики\"", 99.99));
    }

}
