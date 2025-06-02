<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Setting</title>
    <!-- Link đến file CSS chính của bạn -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
    <!-- Font Awesome cho icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <!-- Navbar giống index.jsp -->
    <div class="navbar">
        <div class="navbar-logo">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <h2>SWP391</h2>
            </a>
        </div>
        <div class="navbar-links">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp"
                       class="${pageContext.request.servletPath eq '/index.jsp' ? 'active' : ''}">
                        Home
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/users"
                       class="${pageContext.request.servletPath eq '/WEB-INF/views/user-list.jsp' ? 'active' : ''}">
                        Users
                    </a>
                </li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Reports</a></li>
                <li><a href="${pageContext.request.contextPath}/settings"
                       class="${pageContext.request.servletPath eq '/WEB-INF/views/settingList.jsp' ? 'active' : ''}">
                        Settings
                    </a>
                </li>
            </ul>
        </div>
        <div class="navbar-profile">
            <div class="dropdown">
                <button class="dropbtn">
                    <i class="fa fa-user-circle"></i> Admin
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">Profile</a>
                    <a href="#">Account Settings</a>
                    <div class="dropdown-divider"></div>
                    <a href="#">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Nội dung chính nằm bên dưới navbar -->
    <div class="main-content">
        <div class="box">
            <h1>Danh sách Setting</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Key</th>
                        <th>Value</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${settings}">
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.key}</td>
                            <td>${s.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- CSS riêng cho navbar (nếu chưa có trong style.css) -->
    <style>
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #2c3e50;
            padding: 0 20px;
            color: white;
            height: 60px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        
        .navbar-logo a {
            text-decoration: none;
            color: white;
        }
        
        .navbar-logo h2 {
            margin: 0;
            font-size: 1.5rem;
        }
        
        .navbar-links ul {
            display: flex;
            list-style: none;
            margin: 0;
            padding: 0;
        }
        
        .navbar-links li {
            margin: 0 10px;
        }
        
        .navbar-links a {
            text-decoration: none;
            color: #ecf0f1;
            padding: 10px;
            font-size: 0.9rem;
            transition: all 0.3s ease;
            border-radius: 4px;
        }
        
        .navbar-links a:hover,
        .navbar-links a.active {
            background-color: #34495e;
            color: white;
        }
        
        .navbar-profile {
            position: relative;
        }
        
        .dropdown {
            position: relative;
            display: inline-block;
        }
        
        .dropbtn {
            background-color: transparent;
            color: white;
            padding: 10px;
            font-size: 0.9rem;
            border: none;
            cursor: pointer;
            display: flex;
            align-items: center;
        }
        
        .dropdown-content {
            display: none;
            position: absolute;
            right: 0;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px rgba(0,0,0,0.2);
            z-index: 1;
            border-radius: 4px;
            overflow: hidden;
        }
        
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }
        
        .dropdown-divider {
            height: 1px;
            background-color: #e1e1e1;
            margin: 0;
        }
        
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }
        
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* CSS cho box và table để giống index.jsp */
        .main-content {
            padding: 20px;
        }

        .box {
            background: #fff;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
            margin-top: 20px;
        }

        .box h1 {
            margin-bottom: 20px;
            font-size: 1.5rem;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
        }

        .table th,
        .table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        .table th {
            background-color: #f2f2f2;
        }
    </style>
</body>
</html>
