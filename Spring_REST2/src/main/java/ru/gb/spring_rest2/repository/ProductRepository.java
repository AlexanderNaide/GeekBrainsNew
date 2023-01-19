package ru.gb.spring_rest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.spring_rest2.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Modifying
    @Query("select p.subCategory1 from Product p group by p.subCategory1")
    List<String> findAllCategories();

    @Modifying
    @Query("select p.subCategory2 from Product p where p.subCategory1 = ?1 group by p.subCategory2")
    List<String> findAllSubCategories(String cat);

    @Modifying
    @Query("select p.manufacturer from Product p where p.subCategory1 like ?1 and p.subCategory2 like ?2 group by p.manufacturer")
    List<String> findManufacturer(String cat, String sub_cat);


}
