package ru.gb.HomeWork.Repository.Parents;

import ru.gb.HomeWork.model.TheBuy;
import ru.gb.HomeWork.model.User;

import java.util.List;

public interface BuyDao {

    void insert(TheBuy buy);

    TheBuy get(Long id);

    void delete(TheBuy buy);

    List<TheBuy> getAllBuys();

    List<TheBuy> getBuysFromUser(User user);

    void save(TheBuy buy);

}
