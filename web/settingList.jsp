<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Setting</title>
    <!-- Font Awesome (giống index.jsp) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Dùng cùng file CSS chính như index.jsp -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/global.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            color: #333;
        }
        
        .content-wrapper {
            padding: 20px;
            margin-left: 250px; /* Chừa khoảng cho sidebar */
        }
        
        h1 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        
        .box {
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            padding: 20px;
        }
        
        .table-container {
            margin-top: 20px;
        }
        
        .table-container table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }
        
        .table-container th, 
        .table-container td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        
        .table-container th {
            background-color: #f2f2f2;
            color: #2c3e50;
        }
        
        .table-container tr:hover {
            background-color: #f9f9f9;
        }
        
        .action-button {
            background-color: #2c3e50;
            color: white;
            padding: 6px 12px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 0.9rem;
            transition: background-color 0.3s ease;
        }
        
        .action-button:hover {
            background-color: #34495e;
        }
    </style>
</head>
<body>
    <!-- Include sidebar giống index.jsp -->
    <jsp:include page="/components/sidebar.jsp" />
    
    <div class="content-wrapper">
        <h1>Danh sách Setting</h1>
        
        <div class="box">
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Key</th>
                            <th>Value</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${settings}">
                            <tr>
                                <td>${s.id}</td>
                                <td>${s.key}</td>
                                <td>${s.value}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/settings/edit?id=${s.id}" class="action-button">
                                        <i class="fas fa-edit"></i> Sửa
                                    </a>
                                    <a href="${pageContext.request.contextPath}/settings/delete?id=${s.id}" class="action-button" style="background-color: #e74c3c;">
                                        <i class="fas fa-trash-alt"></i> Xóa
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
