package ru.gb.HomeWork.Repository.Parents;

import ru.gb.HomeWork.model.Product;
import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;
import java.util.List;

public interface UserDao {

    void insert(User user);

    User get(Long id);

    void delete(User user);

    void save(User user);

    List<User> getAll();

    void addPurchase(Long userId, List<Product> productList);

    List<TheBuy> getAllBuys(Long userId);
}
