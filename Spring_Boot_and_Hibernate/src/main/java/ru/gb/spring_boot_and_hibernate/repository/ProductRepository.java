package ru.gb.spring_boot_and_hibernate.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gb.spring_boot_and_hibernate.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> searchAllByTitleContainingAndPriceGreaterThan(String value, Double min);
    List<Product> searchAllByTitleContainingAndPriceGreaterThanAndPriceLessThan(String value, Double min, Double max);

/*    //Пример создания кастомного запроса с параметрами
    @Transactional
    @Modifying
    @Query("UPDATE Product p set p.price = ?2 where p.id = ?1")
    void changePrice(Long id, Double price);*/
}
