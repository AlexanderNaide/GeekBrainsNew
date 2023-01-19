package ru.gb.JavaEE.products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mall/*")
public class Mall extends HttpServlet {
    private ProductRepository productRepository;
    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getPathInfo().substring(1);
        PrintWriter out = resp.getWriter();
        out.printf("<html>");
        if(request.equals("allProducts")){
            out.printf("<head>");
            out.printf("<style>\n" +
                    "table {\n" +
                    "  font-family: arial, sans-serif;\n" +
                    "  border-collapse: collapse;\n" +
                    "  width: 800px;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "  border: 1px solid #dddddd;\n" +
                    "  text-align: left;\n" +
                    "  padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "  background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>");
            out.printf("</head>");

            out.printf("<body><table>");
            out.printf("  <tr><th>Позиция</th><th>Наименование</th><th>Цена</th></tr>");
            for (Product product : productRepository.findAll()) {
                out.printf(String.format("<tr><td>%04d</td><td>%s</td><td>%.2f</td></tr>", product.getId(), product.getTitle(), product.getCost()));
            }
            out.printf("</table>");

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
