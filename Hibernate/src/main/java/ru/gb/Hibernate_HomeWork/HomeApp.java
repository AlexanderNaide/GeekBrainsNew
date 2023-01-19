package ru.gb.Hibernate_HomeWork;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.Hibernate_HomeWork.model.Product;

public class HomeApp {
    private static EntityManagerFactory emFactory;
    private static ProductDao dao;
    public static void init(){
        emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    public static void shutdown(){
        if(emFactory != null){
            dao.close();
            emFactory.close();
        }
    }
    public static void main(String[] args) {
        init();
        dao = new ProductDao(emFactory.createEntityManager());

        // Создали некоторое количество продуктов
        dao.createProduct(new Product("Product5", 999));

        //Запрос 1го продукта по id.
        System.out.println("Запрос 1го продукта по id.");
        System.out.println(dao.findById(1L));

        //Запрос 1го продукта по Title.
        System.out.println("Запрос 1го продукта по Title.");
        System.out.println(dao.findByName("Product5"));

        //Запрос списка всех продуктов
        System.out.println("Запрос списка всех продуктов.");
        dao.findAll().forEach(System.out::println);

        //Удаление по id
        System.out.println("Удаление по id.");
        dao.deleteById(5L);
        dao.findAll().forEach(System.out::println);

        //Удаление по title
        System.out.println("Удаление по title.");
        dao.deleteByName("Product5");
        dao.findAll().forEach(System.out::println);

        //Изменение продукта
        System.out.println("Изменение продукта");
        Product product = dao.findById(4L);
        product.setPrice(299);
        dao.saveOrUpdate(product);
        dao.findAll().forEach(System.out::println);



        shutdown();
    }
}
