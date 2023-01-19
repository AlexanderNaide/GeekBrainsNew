package ru.gb.JavaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sum")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        int firstNumber = Integer.parseInt(req.getParameter("a"));
        int secondNumber = Integer.parseInt(req.getParameter("b"));
        int sum = firstNumber + secondNumber;

        out.println("<html><body><h1>" + String.format("%d + %d + %d", firstNumber, secondNumber, sum));
        out.close();
    }
}
