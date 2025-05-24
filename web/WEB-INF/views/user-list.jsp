<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>User Management - User List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="http://localhost:8080/SWP391GROUP5/style/global.css">
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
            }

            h1 {
                color: #2c3e50;
                margin-bottom: 20px;
                padding-bottom: 10px;
                border-bottom: 1px solid #ddd;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                background-color: white;
                box-shadow: 0 1px 3px rgba(0,0,0,0.1);
                border-radius: 5px;
                overflow: hidden;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 12px;
                text-align: left;
            }

            th {
                background-color: #2c3e50;
                color: white;
                font-weight: 500;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f1f1f1;
            }

            .status {
                display: inline-block;
                padding: 4px 8px;
                border-radius: 4px;
                font-size: 0.85em;
            }

            .status-active {
                background-color: #dff0d8;
                color: #3c763d;
            }

            .status-inactive {
                background-color: #f2dede;
                color: #a94442;
            }

            .action-buttons {
                display: flex;
                gap: 5px;
            }

            .btn {
                display: inline-block;
                padding: 4px 8px;
                border-radius: 4px;
                font-size: 0.85em;
                cursor: pointer;
                text-decoration: none;
                text-align: center;
            }

            .btn-edit {
                background-color: #3498db;
                color: white;
            }

            .btn-delete {
                background-color: #e74c3c;
                color: white;
            }
        </style>
    <body>
        <!-- Include the sidebar component -->
        <jsp:include page="/components/sidebar.jsp" />

        <div class="content-wrapper">
            <h1>
                <i class="fas fa-users"></i> User Management 
            </h1>

            <div class="search-and-actions" style="display: flex; justify-content: space-between; margin-bottom: 20px;">
                <div class="search">
                    <input type="text" placeholder="Search users..." style="padding: 8px; border-radius: 4px; border: 1px solid #ddd; width: 250px;">
                    <button class="btn" style="background-color: #2c3e50; color: white; border: none; padding: 8px 12px; border-radius: 4px;">
                        <i class="fas fa-search"></i> Search
                    </button>
                </div>
                <div>
                    <button class="btn" style="background-color: #27ae60; color: white; border: none; padding: 8px 12px; border-radius: 4px;">
                        <i class="fas fa-plus"></i> Add New User
                    </button>
                </div>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.fullName}</td>
                            <td>${user.email}</td>
                            <td>${user.role.name}</td>
                            <td>
                                <c:if test="${user.active}">
                                    <span class="status status-active">Active</span>
                                </c:if>
                                <c:if test="${!user.active}">
                                    <span class="status status-inactive">Inactive</span>
                                </c:if>
                            </td>
                            <td>
                                <div class="action-buttons">
                                    <a href="#" class="btn btn-edit"><i class="fas fa-edit"></i> Edit</a>
                                    <a href="#" class="btn btn-delete"><i class="fas fa-trash"></i> Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html> 