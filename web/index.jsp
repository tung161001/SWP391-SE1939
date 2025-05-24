<%-- 
    Document   : index
    Created on : May 24, 2025, 12:16:22 AM
    Author     : thang
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard - SWP391 Project</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="./style/global.css">
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
            }
            
            .dashboard-stats {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 20px;
                margin-bottom: 30px;
            }
            
            .stat-card {
                background-color: white;
                border-radius: 5px;
                box-shadow: 0 1px 3px rgba(0,0,0,0.1);
                padding: 20px;
                display: flex;
                align-items: center;
            }
            
            .stat-icon {
                width: 60px;
                height: 60px; 
                justify-content: center;
                font-size: 1.8rem;
                margin-right: 15px;
            }
            
            .users-icon {
                background-color: #3498db;
                color: white;
            }
            
            .projects-icon {
                background-color: #2ecc71;
                color: white;
            }
            
            .tasks-icon {
                background-color: #e74c3c;
                color: white;
            } 
            
            .reports-icon {
                background-color: #f39c12;
                color: white;
            }
            
            .stat-info h3 {
                font-size: 1.5rem;
                margin-bottom: 5px;
            }
            
            .stat-info p {
                color: #7f8c8d; 
                display: grid;
                grid-template-columns: 2fr 1fr;
                gap: 20px;
            }
            
            .recent-activity, .quick-actions {
                background-color: white;
                border-radius: 5px;
                box-shadow: 0 1px 3px rgba(0,0,0,0.1);
                padding: 20px;
            }
            
            .section-title {
                font-size: 1.2rem;
                margin-bottom: 15px;
                color: #2c3e50;
                display: flex;
                align-items: center;
            }
            
            .section-title i {
                margin-right: 10px;
            }
            
            .activity-list {
                list-style: none;
            }
            
            .activity-item {
                padding: 12px 0;
                border-bottom: 1px solid #ecf0f1;
                display: flex;
                align-items: center;
            }
            
            .activity-icon {
                width: 36px;
                height: 36px;
                border-radius: 50%;
                display: flex;
                align-items: center;
                justify-content: center;
                margin-right: 12px;
                font-size: 1rem;
            }
            
            .activity-content {
                flex-grow: 1;
            }
            
            .activity-content p {
                margin: 0;
                line-height: 1.4;
            }
            
            .activity-time {
                color: #95a5a6;
                font-size: 0.8rem;
            }
            
            .action-button {
                display: block;
                background-color: #2c3e50;
                color: white;
                text-align: center;
                padding: 12px;
                margin-bottom: 10px;
                border-radius: 4px;
                text-decoration: none;
                transition: background-color 0.3s;
            }
            
            .action-button:hover {
                background-color: #34495e;
            }
            
            .action-button i {
                margin-right: 8px;
            }
            
            @media (max-width: 900px) {
                .dashboard-content {
                    grid-template-columns: 1fr;
                }
            }
        </style>
    </head>
    <body>
        <!-- Include your navbar or sidebar component -->
        <jsp:include page="/components/sidebar.jsp" />
        
        <div class="content-wrapper">
            <h1>Dashboard</h1>
            
            <div class="dashboard-stats">
                <div class="stat-card">
                    <div class="stat-icon users-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <div class="stat-info">
                        <h3>5</h3>
                        <p>Total Users</p>
                    </div>
                </div>
                
                <div class="stat-card">
                    <div class="stat-icon projects-icon">
                        <i class="fas fa-project-diagram"></i>
                    </div>
                    <div class="stat-info">
                        <h3>8</h3>
                        <p>Active Projects</p>
                    </div>
                </div>
                
                <div class="stat-card">
                    <div class="stat-icon tasks-icon">
                        <i class="fas fa-tasks"></i>
                    </div>
                    <div class="stat-info">
                        <h3>24</h3>
                        <p>Pending Tasks</p>
                    </div>
                </div>
                
                <div class="stat-card">
                    <div class="stat-icon reports-icon">
                        <i class="fas fa-chart-bar"></i>
                    </div>
                    <div class="stat-info">
                        <h3>12</h3>
                        <p>Reports</p>
                    </div>
                </div>
            </div>
            
            <div class="dashboard-content">
                <div class="recent-activity">
                    <h2 class="section-title"><i class="fas fa-history"></i> Recent Activity</h2>
                    <ul class="activity-list">
                        <li class="activity-item">
                            <div class="activity-icon" style="background-color: #3498db; color: white;">
                                <i class="fas fa-user-plus"></i>
                            </div>
                            <div class="activity-content">
                                <p><strong>New user</strong> Alice Williams was added</p>
                                <p class="activity-time">2 hours ago</p>
                            </div>
                        </li>
                        <li class="activity-item">
                            <div class="activity-icon" style="background-color: #2ecc71; color: white;">
                                <i class="fas fa-tasks"></i>
                            </div>
                            <div class="activity-content">
                                <p><strong>Task updated</strong> UI Design for Project X</p>
                                <p class="activity-time">5 hours ago</p>
                            </div>
                        </li>
                        <li class="activity-item">
                            <div class="activity-icon" style="background-color: #e74c3c; color: white;">
                                <i class="fas fa-exclamation-circle"></i>
                            </div>
                            <div class="activity-content">
                                <p><strong>Issue reported</strong> Login system error</p>
                                <p class="activity-time">Yesterday</p>
                            </div>
                        </li>
                        <li class="activity-item">
                            <div class="activity-icon" style="background-color: #f39c12; color: white;">
                                <i class="fas fa-file-alt"></i>
                            </div>
                            <div class="activity-content">
                                <p><strong>Report generated</strong> Monthly progress report</p>
                                <p class="activity-time">2 days ago</p>
                            </div>
                        </li>
                    </ul>
                </div>
                
                <div class="quick-actions">
                    <h2 class="section-title"><i class="fas fa-bolt"></i> Quick Actions</h2>
                    <a href="${pageContext.request.contextPath}/users" class="action-button">
                        <i class="fas fa-users"></i> View All Users
                    </a>
                    <a href="#" class="action-button">
                        <i class="fas fa-plus"></i> Create New Project
                    </a>
                    <a href="#" class="action-button">
                        <i class="fas fa-tasks"></i> Manage Tasks
                    </a>
                    <a href="#" class="action-button">
                        <i class="fas fa-cog"></i> System Settings
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
