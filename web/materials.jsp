<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản lý Vật tư</title>
    <style>
        * { box-sizing: border-box; font-family: Arial, sans-serif; margin: 0; padding: 0; }
        body { display: flex; min-height: 100vh; background: #f0f2f5; }

        /* Sidebar */
        .sidebar {
            width: 220px;
            background: #1e2a38;
            color: white;
            padding: 20px;
            flex-shrink: 0;
        }

        .sidebar h2 {
            font-size: 20px;
            margin-bottom: 30px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px 0;
            border-bottom: 1px solid #2f3e4e;
        }

        .sidebar a:hover {
            background-color: #2f3e4e;
            padding-left: 10px;
        }

        /* Main content */
        .main {
            flex: 1;
            padding: 30px;
        }

        .main h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .form-section {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 1px 4px rgba(0,0,0,0.1);
            margin-bottom: 30px;
            max-width: 500px;
        }

        .form-section label {
            display: block;
            margin: 10px 0 5px;
        }

        .form-section input[type="text"],
        .form-section input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-section input[type="submit"] {
            margin-top: 15px;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-section input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Table */
        table {
            width: 100%;
            background: white;
            border-collapse: collapse;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f7f7f7;
            text-align: left;
        }

        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<jsp:include page="/components/sidebar.jsp" />

<!-- Main Content -->
<div class="main">
    <h1>Thêm vật tư mới</h1>

    <div class="form-section">
        <form action="../materials" method="post">
            <label>Tên vật tư:</label>
            <input type="text" name="name" required>

            <label>Mã vật tư:</label>
            <input type="text" name="code" required>

            <label>Đơn vị:</label>
            <input type="text" name="unit" required>

            <label>Giá:</label>
            <input type="number" name="price" step="0.01" required>

            <input type="submit" value="Thêm vật tư">
        </form>
    </div>

    <h1>Danh sách vật tư</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Mã</th>
            <th>Đơn vị</th>
            <th>Giá</th>
        </tr>
        <c:forEach var="m" items="${materials}">
            <tr>
                <td>${m.id}</td>
                <td>${m.name}</td>
                <td>${m.code}</td>
                <td>${m.unit}</td>
                <td>${m.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
