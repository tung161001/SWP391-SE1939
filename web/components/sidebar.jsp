<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<div class="sidebar">
    <div class="sidebar-header">
        <h3>SWP391 Admin</h3>
        <button id="sidebar-toggle" class="sidebar-toggle">
            <i class="fas fa-bars"></i>
        </button>
    </div>
    
    <div class="sidebar-user">
        <div class="user-avatar">
            <i class="fas fa-user-circle"></i>
        </div>
        <div class="user-info">
            <span class="user-name">${user.fullName}</span>
            <span class="user-role">${user.getRole().name}</span>
        </div>
    </div>
    
    <ul class="sidebar-menu">
        <li class="sidebar-item ${pageContext.request.servletPath eq '/index.jsp' ? 'active' : ''}">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <i class="fas fa-home"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="sidebar-item ${pageContext.request.servletPath eq '/WEB-INF/views/user-list.jsp' ? 'active' : ''}">
            <a href="${pageContext.request.contextPath}/users">
                <i class="fas fa-users"></i>
                <span>Users</span>
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#">
                <i class="fas fa-project-diagram"></i>
                <span>Projects</span>
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#">
                <i class="fas fa-tasks"></i>
                <span>Tasks</span>
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#">
                <i class="fas fa-chart-bar"></i>
                <span>Reports</span>
            </a>
        </li>
        <li class="sidebar-title">System</li>
        <li class="sidebar-item">
            <a href="#">
                <i class="fas fa-cog"></i>
                <span>Settings</span>
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#">
                <i class="fas fa-sign-out-alt"></i>
                <span>Logout</span>
            </a>
        </li>
    </ul>
</div>
              
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const toggleBtn = document.getElementById('sidebar-toggle');
        const sidebar = document.querySelector('.sidebar');
        const body = document.body;
        
        toggleBtn.addEventListener('click', function() {
            sidebar.classList.toggle('collapsed');
            body.classList.toggle('sidebar-collapsed');
        });
    });
</script>

<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> 