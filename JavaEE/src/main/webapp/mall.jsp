<%@ page import="ru.gb.JavaEE.products.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: al121
  Date: 08.12.2022
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 800px;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <table>
        <tr><th>Позиция</th><th>Наименование</th><th>Цена</th></tr>

        <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
        <tr>
            <td>
                <%= String.format("%04d", product.getId()) %>
            </td>
            <td>
                <a href="<%= application.getContextPath() + "/newmall/" + product.getId()%>">
                <%= String.format("%s", product.getTitle()) %>
                </a>
            </td>
            <td>
                <%= String.format("%.2f", product.getCost()) %>
            </td>
        </tr>
        <% } %>

    </table>
</body>
</html>
