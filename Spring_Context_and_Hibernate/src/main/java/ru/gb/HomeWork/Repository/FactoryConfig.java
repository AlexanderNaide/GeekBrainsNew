package ru.gb.HomeWork.Repository;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.gb.HomeWork")
public class FactoryConfig {

    @Bean
    public EntityManagerFactory getFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

}
