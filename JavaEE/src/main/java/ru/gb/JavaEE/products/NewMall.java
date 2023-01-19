package ru.gb.JavaEE.products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/newmall/*")
public class NewMall extends HttpServlet {
    private ProductRepository productRepository;
    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getPathInfo().substring(1);
        PrintWriter out = resp.getWriter();
        if(request.equals("allProducts")){
            List<Product> products = productRepository.findAll();
            req.setAttribute("products", products);
            getServletContext().getRequestDispatcher("/mall.jsp").forward(req, resp); // так прокидываются обработанные запросы на jsp файл, который занимается построением страницы в паттерне MVC

        }else if(request.matches("\\d+")) {
            int pos = Integer.parseInt(request);
            Product product = productRepository.findById(pos);
            out.printf(String.format("<body><h1>Товар %04d: %s, цена: %.2f</h1>", product.getId(), product.getTitle(), product.getCost()));
        }else {
            out.printf("<body><h1>Запрос \"" + request + "\" не распознан</h1>");
        }
        out.printf("</body></html>");
        out.close();

    }
}
