package ru.gb.SpringContext.HomeWork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.SpringContext.HomeWork");

        Cart cart = context.getBean(Cart.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        while (!command.equals("exit")){
            String[] split = command.split(" ");
            switch (split[0]){
                case "cart" -> print(cart.getCart());
                case "add" -> {
                    try{
                        cart.addProduct(Long.parseLong(split[1]));
                    }catch (RuntimeException e){
                        System.out.println("Товар отсутствует в базе.");
                    }
                    System.out.println("Корзина:");
                    print(cart.getCart());
                }
                case "remove" -> {
                    try{
                        cart.removeProduct(Long.parseLong(split[1]));
                    }catch (RuntimeException e){
                        System.out.println("Товар отсутствует в базе.");
                    }
                    System.out.println("Корзина:");
                    print(cart.getCart());
                }
                case "all" -> {
                    print(productRepository.findAll());
                }
            }
            command = reader.readLine();
        }

        reader.close();
        context.close();
    }

    public static void print(List<Product> list){
        list.forEach(p -> System.out.println(p.getId() + " " + p.getTitle() + " " + p.getPrice()));
    }
}
