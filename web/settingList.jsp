<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>System Settings</title>
    <style>
        * { box-sizing: border-box; font-family: Arial, sans-serif; margin: 0; padding: 0; }
        body { min-height: 100vh; background: #f0f2f5; }

        /* Main content */
        .main {
            padding: 30px;
            max-width: 800px;
            margin: auto;
        }

        .main h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

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

    <!-- Main content -->
    <div class="main">
        <h1>System Settings</h1>

        <table>
            <tr>
                <th>ID</th>
                <th>Key</th>
                <th>Value</th>
            </tr>
            <c:forEach var="s" items="${settings}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.key}</td>
                    <td>${s.value}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<jsp:include page="/components/sidebar.jsp" />  
</body>
</html>
