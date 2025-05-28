<%-- 
    Document   : login
    Created on : May 24, 2025, 3:52:35 PM
    Author     : thang
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
    String rememberedEmail = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("rememberedEmail")) {
                rememberedEmail = c.getValue();
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style>
            body {
                font-family: Arial;
                background-color: yellow;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .login-container {
                background-color: yellow;
                border: 1px solid black;
                padding: 20px;
                width: 350px;
            }
            .form-group {
                margin-bottom: 10px;
            }
            input, button {
                width: 100%;
                padding: 8px;
                margin-top: 4px;
            }
            .message {
                color: red;
                font-weight: bold;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Login</h2>
            <form action="login" method="post">
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" name="email" value="<%= rememberedEmail %>" required />
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" required />
                </div>
                <div class="form-group">
                    <input type="checkbox" name="remember" <% if(!rememberedEmail.isEmpty()) out.print("checked"); %> />
                    <label>Remember Me</label>
                </div>
                <div class="form-group">
                    <button type="submit">Login</button>
                </div>
                <div class="form-group">
                    <button type="button" onclick="location.href = 'reset.jsp'">Reset Password</button>
                </div>
                <div class="form-group">
                    <button type="button" onclick="alert('Redirecting to Google...')">Login with Google</button>
                </div>
                <% if (message != null) { %>
                <div class="message"><%= message %></div>
                <% } %>
            </form>
        </div>
    </body>
</html>

