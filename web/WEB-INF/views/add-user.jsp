<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>User Management - Add New User</title>
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

            .form-container {
                background-color: white;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 1px 3px rgba(0,0,0,0.1);
                max-width: 800px;
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: 500;
            }

            input[type="text"],
            input[type="email"],
            input[type="password"],
            select {
                width: 100%;
                padding: 8px 12px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 1em;
            }

            .form-actions {
                margin-top: 20px;
                display: flex;
                gap: 10px;
            }

            .btn {
                display: inline-block;
                padding: 8px 16px;
                border-radius: 4px;
                font-size: 1em;
                cursor: pointer;
                text-decoration: none;
                text-align: center;
                border: none;
            }

            .btn-primary {
                background-color: #3498db;
                color: white;
            }

            .btn-secondary {
                background-color: #95a5a6;
                color: white;
            }

            .alert {
                padding: 10px;
                margin-bottom: 15px;
                border-radius: 4px;
            }

            .alert-danger {
                background-color: #f2dede;
                color: #a94442;
            }
        </style>
    </head>
    <body>
        <!-- Include the sidebar component -->
        <jsp:include page="/components/sidebar.jsp" />

        <div class="content-wrapper">
            <h1>
                <i class="fas fa-user-plus"></i> Add New User
            </h1>

            <div class="form-container">
                <!-- Display error message if any -->
                <c:if test="${not empty sessionScope.error}">
                    <div class="alert alert-danger">
                        ${sessionScope.error}
                        <% session.removeAttribute("error"); %>
                    </div>
                </c:if>

                <form action="AddUser" method="POST">
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" id="fullName" name="fullName" required />
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" required />
                    </div>
                    
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" required />
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required />
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required />
                    </div>

                    <div class="form-group">
                        <label for="roleId">Role</label>
                        <select id="roleId" name="roleId" required>
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}">${role.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="status">Status</label>
                        <select id="status" name="status">
                            <option value="1" selected>Active</option>
                            <option value="0">Inactive</option>
                        </select>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-save"></i> Save User
                        </button>
                        <a href="users" class="btn btn-secondary">
                            <i class="fas fa-times"></i> Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html> 