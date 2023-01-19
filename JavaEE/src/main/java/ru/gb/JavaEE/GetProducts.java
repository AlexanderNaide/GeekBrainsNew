package ru.gb.JavaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/products")
public class GetProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "Молоко", 67.99));
        list.add(new Product(2, "Колбаса \"Докторская\"", 339.99));
        list.add(new Product(3, "Томаты \"Черри\"", 320.00));
        list.add(new Product(4, "Marshmello", 130.00));
        list.add(new Product(5, "Котлеты \"Веганские\"", 229.99));
        list.add(new Product(6, "Кефир", 87.99));
        list.add(new Product(7, "Огурцы", 240.30));
        list.add(new Product(9, "Молоко \"Немолоко\"", 88.00));
        list.add(new Product(8, "Шоколад \"Аленка\"", 59.99));
        list.add(new Product(10, "Крекер \"Рыбкины хвостики\"", 99.99));

        PrintWriter out = resp.getWriter();

        out.printf("<html><body>");

        list.forEach(p -> {
            System.out.println(p.getId() + " " + p.getTitle());
        });

/*        String[] split = "Cart add edd".split(" ");
        switch (split[0]){
            case "cart" -> System.out.println("fjfjj");

            case "add" -> {
            }
            case "remove" -> {
            }
            case "all" -> {
            }
        }*/

        for (Product product : list) {
            out.printf("<h1>");
            out.printf(String.format("Товар %04d: %s, цена: %.2f", product.getId(), product.getTitle(), product.getCost()));
            out.printf("</h1>");
        }


        out.printf("</body></html>");
        out.close();
    }
}
