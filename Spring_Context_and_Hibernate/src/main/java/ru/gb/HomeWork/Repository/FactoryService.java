package ru.gb.HomeWork.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryService {

    private static EntityManagerFactory managerFactory;

    @Autowired
    public void setManagerFactory(EntityManagerFactory managerFactory) {
        FactoryService.managerFactory = managerFactory;
    }

    public EntityManager getManager(){
        return managerFactory.createEntityManager();
    }
}
