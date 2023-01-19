package ru.gb.HomeWork.Repository.Parents;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.Repository.FactoryService;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.User;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class Repository {

    private FactoryService factoryService;
    private EntityManager em;

    @Autowired
    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @PostConstruct
    public void init(){
        em = factoryService.getManager();
    }

    protected <R> R executeForEntityManager(Function<EntityManager, R> function){
        EntityManager em = factoryService.getManager();
        try{
            return function.apply(em);
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    protected void executeInTransaction(Consumer<EntityManager> consumer){
        EntityManager em = factoryService.getManager();
        try{
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

//    public void addBuy(Long userId, Long productId) {
//        executeInTransaction(entityManager -> {
//            entityManager.find(User.class, userId).getProducts().add(entityManager.find(Product.class, productId));
//        });
//    }
}
