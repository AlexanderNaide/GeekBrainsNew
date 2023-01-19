package ru.gb.HomeWork.Repository;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.Repository.Parents.ProductDao;
import ru.gb.HomeWork.Repository.Parents.Repository;
import ru.gb.HomeWork.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ProductRepository extends Repository implements ProductDao {


    @Override
    public void insert(Product product) {
        executeInTransaction(entityManager ->
                entityManager.persist(product));
    }

    @Override
    public Product get(Long id) {
        return executeForEntityManager(entityManager -> {
//            Product product = entityManager.find(Product.class, id);
//            product.setUsers(new ArrayList<>(product.getUsers()));
//            На самом деле вопрос с загрузкой List надо было решать так:
            Product product = (Product) entityManager.createQuery("select p from Product p join fetch p.usersList where p.id=:id").setParameter("id", id).getSingleResult();
            return product;
            }
        );
    }

    @Override
    public void delete(Product product) {
        executeInTransaction(entityManager ->
                entityManager.remove(product));
    }

    @Override
    public List<Product> getAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("select p from Product p", Product.class).getResultList()
        );
    }

    @Override
    public void save(Product product) {
        executeInTransaction(entityManager ->
                entityManager.merge(product));
    }

}
