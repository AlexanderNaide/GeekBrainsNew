package ru.gb.Hibernate_HomeWork;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import ru.gb.Hibernate_HomeWork.model.Product;

import java.util.List;

public class ProductDao {

//    private static EntityManagerFactory emFactory;
    private final EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createProduct(Product p){
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    public Product findById(Long id){
        return entityManager.find(Product.class, id);
    }

    public Product findByName(String name){
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.title = :name", Product.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<Product> findAll(){
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    public void deleteById(Long id){
        Product p = findById(id);
        if(p != null){
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        }
    }

    public void deleteByName(String name){
        Product p = findByName(name);
        if(p != null){
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product p) {
        entityManager.merge(p);
    }

    public void close() {
        entityManager.close();
    }

}
