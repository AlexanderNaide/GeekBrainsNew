package ru.gb.JavaEE.products;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 *
 * ServletContextListener - когда такой есть, он создается перед всеми сервлетами
 *
 * Важно!!!
 * Если в проекте есть база данных, то ее подключение происходит именно здесь,
 * затем так же, через getServletContext передается соединение другим сервлетам.
 *
 */



@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext(); //К этой штуке есть доступ у всех сервлетов

        ProductRepository productRepository = new ProductRepository();

        sc.setAttribute("productRepository", productRepository);
        // А так мы создаем аттрибут с заданным именем, и по вызову этого аттрибута мы можем получить
        // productRepository в любом сервлете и он всегда будет одним обьектом, как и должен (общим)


        productRepository.insert(new Product("Молоко", 67.99));
        productRepository.insert(new Product("Колбаса \"Докторская\"", 339.99));
        productRepository.insert(new Product("Томаты \"Черри\"", 320.00));
        productRepository.insert(new Product("Marshmello", 130.00));
        productRepository.insert(new Product("Котлеты \"Веганские\"", 229.99));
        productRepository.insert(new Product("Кефир", 87.99));
        productRepository.insert(new Product("Огурцы", 240.30));
        productRepository.insert(new Product("Молоко \"Немолоко\"", 88.00));
        productRepository.insert(new Product("Шоколад \"Аленка\"", 59.99));
        productRepository.insert(new Product("Крекер \"Рыбкины хвостики\"", 99.99));
    }
}
