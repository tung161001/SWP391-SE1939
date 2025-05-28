<%-- 
    Document   : success
    Created on : May 28, 2025, 10:19:51 AM
    Author     : Doan PC
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = (String) request.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head><title>Success</title></head>
<body style="text-align:center; padding-top:50px;">
    <h2>Welcome, <%= email %>!</h2>
    <p>Login successful!</p>
</body>
</html>

