<%-- 
    Document   : materials
    Created on : May 28, 2025, 10:27:31 AM
    Author     : Doan PC
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.Material" %>
<html>
<head>
    <title>Materials Management</title>
    <style>
        table { border-collapse: collapse; width: 100%; background: #ffff99; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
        th { background: yellow; }
    </style>
</head>
<body>
    <h2>Materials Management</h2>
    <table>
        <tr>
            <th>Material Code</th>
            <th>Material Name</th>
            <th>Category</th>
            <th>Unit</th>
            <th>Quantity</th>
            <th>Minimum Stock Level</th>
            <th>Supplier</th>
            <th>Status</th>
        </tr>
        <%
            List<Material> materials = (List<Material>) request.getAttribute("materials");
            for (Material m : materials) {
        %>
        <tr>
            <td><%= m.getCode() %></td>
            <td><%= m.getName() %></td>
            <td><%= m.getCategory() %></td>
            <td><%= m.getUnit() %></td>
            <td><%= m.getQuantity() %></td>
            <td><%= m.getMinStock() %></td>
            <td><%= m.getSupplier() %></td>
            <td><%= m.getStatus() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
