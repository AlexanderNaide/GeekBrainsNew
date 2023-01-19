package ru.gb.HomeWork.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.Repository.Parents.Repository;
import ru.gb.HomeWork.Repository.Parents.UserDao;
import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class UserRepository extends Repository implements UserDao {


    @Override
    public void insert(User user) {
        executeInTransaction(entityManager ->
                entityManager.persist(user));
    }

    @Override
    public User get(Long id) {
        return executeForEntityManager(entityManager -> {
            User user = entityManager.find(User.class, id);
            user.setBuyList(new ArrayList<>(user.getBuyList()));
//            На самом деле вопрос с загрузкой List надо было решать так:
//            User user1 = (User) entityManager.createQuery("select u from User u join fetch u.buyList where u.id=:id").setParameter("id", id).getSingleResult();

                    return user;
            }
        );
    }

    @Override
    public void delete(User user) {
        executeInTransaction(entityManager ->
                entityManager.remove(user));
    }

    @Override
    public void save(User user) {
        executeInTransaction(entityManager ->
                entityManager.merge(user));
    }

    @Override
    public List<User> getAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("select p from User p", User.class).getResultList()
        );
    }

    @Override
    public void addPurchase(Long userId, List<Product> productList) {
        executeInTransaction(entityManager -> {
            User user = entityManager.find(User.class, userId);
            TheBuy buy = new TheBuy(user, productList);
            user.getBuyList().add(buy);
        });
    }

    @Override
    public List<TheBuy> getAllBuys(Long userId) {
        return executeForEntityManager(entityManager ->
            new ArrayList<TheBuy>(entityManager.find(User.class, userId).getBuyList())
        );
    }

    public List<TheBuy> getAllPayProducts(Long userId) {
        return executeForEntityManager(entityManager ->
                new ArrayList<TheBuy>(entityManager.find(User.class, userId).getBuyList())
        );
    }

}
