<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Material" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Material List</title>
</head>
<body>
<h2>All Materials</h2>

<form method="post" action="MaterialServlet">
    <input type="hidden" name="action" value="filter">
    Category: <input type="text" name="category">
    <input type="submit" value="Filter">
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Code</th>
        <th>Unit</th>
        <th>Price</th>
        <th>Category</th>
    </tr>
    <%
        List<Material> list = (List<Material>) request.getAttribute("materials");
        if (list != null) {
            for (Material m : list) {
    %>
        <tr>
            <td><%= m.getId() %></td>
            <td><%= m.getName() %></td>
            <td><%= m.getCode() %></td>
            <td><%= m.getUnit() %></td>
            <td><%= m.getPrice() %></td>
            <td><%= m.getCategory() %></td>
        </tr>
    <%
            }
        }
    %>
</table>

<h3>Create New Material</h3>
<form method="post" action="MaterialServlet">
    <input type="hidden" name="action" value="create">
    Name: <input type="text" name="name"><br>
    Code: <input type="text" name="code"><br>
    Unit: <input type="text" name="unit"><br>
    Price: <input type="number" step="0.01" name="price"><br>
    Category: <input type="text" name="category"><br>
    <input type="submit" value="Create">
</form>

</body>
</html>
