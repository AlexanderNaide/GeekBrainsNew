package ru.gb.JavaEE;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")  // тут также можно фильтроваться по запросу. В данном случае берутся все запросы, которые заходят за /
public class EncodingFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse); // - это значит, что фильтр пробросил запрос дальше без изменений.
        // На самом деле фильтром тут можно модифицировать запросы и ответы, проверять параметры запроса.
        // Одно из назначений фильтра - проверять например авторизацию и перекидывать на определенные сервлеты в зависимости от запроса
    }

    @Override
    public void destroy() {
    }
}
