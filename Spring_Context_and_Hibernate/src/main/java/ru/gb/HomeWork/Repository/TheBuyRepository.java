package ru.gb.HomeWork.Repository;


import jakarta.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.HomeWork.Repository.Parents.BuyDao;
import ru.gb.HomeWork.Repository.Parents.Repository;
import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Scope("prototype")
public class TheBuyRepository extends Repository implements BuyDao {


    @Override
    public void insert(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.persist(buy));
    }

    @Override
    public TheBuy get(Long id) {
        return executeForEntityManager(entityManager ->
                entityManager.find(TheBuy.class, id)
        );
    }

    @Override
    public void delete(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.remove(buy));
    }

    @Override
    public List<TheBuy> getAllBuys() {
        return executeForEntityManager(entityManager ->
                entityManager.createQuery("from TheBuy", TheBuy.class).getResultList()
        );
    }

    @Override
    public List<TheBuy> getBuysFromUser(User user) {
        return executeForEntityManager(entityManager -> {
                    List<TheBuy> list = entityManager.createQuery("select b from TheBuy b where b.buyer = :name", TheBuy.class).setParameter("user", user).getResultList();
                    list.forEach(b -> b.setProductsList(new ArrayList<>(b.getProductsList())));
                    return list;
                }
        );
    }

    @Override
    public void save(TheBuy buy) {
        executeInTransaction(entityManager ->
                entityManager.merge(buy));
    }

    public List<String> method1(Long id) {
        return executeForEntityManager(entityManager -> {
                    String sql = "select b.create_date, pr.price, pr.title from buys b " +
                            "inner join purchase p " +
                            "on b.id = p.buy_id " +
                            "inner join products pr " +
                            "on p.product_id = pr.id " +
                            "where b.user_id = :id " +
                            "order by b.create_date desc";

                    Query query = entityManager.createNativeQuery(sql);
                    query.setParameter("id", id);
                    List<Object[]> objects = query.getResultList();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
                    List<String> resp = new ArrayList<>();
                    for (Object[] o : objects) {
                        resp.add(String.format("Покупка: %s      Цена: %s      Наименование: %s", formatter.format(o[0]), o[1], o[2]));
                    }

                    return resp;
                }
        );
    }


    public List<String> method2(Long id) {
        return executeForEntityManager(entityManager -> {

                    Query query = entityManager.createNativeQuery("select b.create_date from buys b where b.user_id= :id order by b.create_date", Date.class);
                    query.setParameter("id", id);

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
                    List<String> resp = new ArrayList<>();
                    List<Date> objects = query.getResultList();
                    for (Date o : objects) {
                        resp.add(String.format("Покупка: %s", formatter.format(o)));
                    }
                    return resp;

                }
        );
    }

    public List<String> method3(Long id) {
        return executeForEntityManager(entityManager -> {
                    String sql = "select b.create_date, pr.price, u.name from users u " +
                            "inner join buys b " +
                            "on b.user_id = u.id " +
                            "inner join purchase p " +
                            "on p.buy_id = b.id " +
                            "inner join products pr " +
                            "on pr.id = p.product_id " +
                            "where pr.id = :id " +
                            "order by b.create_date;";
                    Query query = entityManager.createNativeQuery(sql);
                    query.setParameter("id", id);
                    List<Object[]> objects = query.getResultList();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
                    List<String> resp = new ArrayList<>();
                    for (Object[] o : objects) {
                        resp.add(String.format("Покупка: %s      Цена: %s      Покупатель: %s", formatter.format(o[0]), o[1], o[2]));
                    }
                    return resp;
                }
        );
    }

    public List<String> method4() {
        return executeForEntityManager(entityManager -> {
                    String sql = "select u.name, sum(pr.price) s from users u " +
                            "left join buys b " +
                            "on b.user_id = u.id " +
                            "left join purchase p " +
                            "on p.buy_id = b.id " +
                            "left join products pr " +
                            "on pr.id = p.product_id " +
                            "group by u.name " +
                            "order by s desc, u.name desc";
                    Query query = entityManager.createNativeQuery(sql);
                    List<Object[]> objects = query.getResultList();
                    List<String> resp = new ArrayList<>();
                    for (Object[] o : objects) {
                        resp.add(String.format("%s       Сумма средств: %.2f", o[0], o[1] != null ? (Double)o[1] : 0.0 ));
                    }
                    return resp;
                }
        );
    }

}
