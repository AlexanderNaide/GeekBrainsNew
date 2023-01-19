package ru.gb.JavaEE.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductRepository {

    private final Map<Integer, Product> map = new ConcurrentHashMap<>();

    private final AtomicInteger identity = new AtomicInteger(0);

    public List<Product> findAll(){
        return new ArrayList<>(map.values());
    }

    public Product findById(int id){
        return map.get(id);
    }

    public void insert(Product product){
        int id = identity.incrementAndGet();
        product.setId(id);
        map.put(id, product);
    }

    public void update(Product product){
        map.put(product.getId(), product);
    }

    public void delete(int id){
        map.remove(id);
    }

}
