<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.0.2/tailwind.min.css">

        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                border: 1px solid #ddd; /* Thêm border cho toàn bộ bảng */
            }
            .container {
                width: 90%;
                margin: 0 auto; /* Để căn giữa container */
                /* Thêm các thuộc tính khác tùy theo nhu cầu */
                margin-bottom: 20px
            }
            h2{
                padding-top: 10px;
                text-align: center;
                font-family: Arial, sans-serif;
                font-size: 50px;
                font-style: initial
            }
            th,
            td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd; /* Thêm đường kẻ bên dưới mỗi ô */
                border-right: 1px solid #ddd; /* Thêm đường kẻ bên phải mỗi ô */
            }

            th:last-child,
            td:last-child {
                border-right: none; /* Loại bỏ đường kẻ bên phải của ô cuối cùng */
            }
            th.id {
                width: 30px;
            }
            th.date {
                width: 100px;
            }
            th {
                text-align: center;
            }
            td{
                text-align: center;
            }
            .toolbar {
                display: flex;
                justify-content: center; /* Căn giữa theo chiều ngang */
                align-items: center; /* Căn giữa theo chiều dọc */
                margin: 5px 5px;
                height: 100px; /* Đảm bảo thanh toolbar chiếm toàn bộ chiều cao của màn hình */
            }

            .toolbar_right {
                display: flex;
                align-items: center;
            }


            #add-button {
                padding: 15px 25px;
                background-color: #4caf50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            #add-button:hover {
                background-color: #45a049;
            }
            .btn {
                width: 100px;
                height: 40px;
                border: 3px solid #ff6633;
                border-radius: 45px;
                transition: all 0.3s;
                cursor: pointer;
                background: white;
                font-size: 1.2em;
                font-weight: 250;
                font-family: 'Montserrat', sans-serif;
                margin: 5px 10px;
            }

            .btn:hover {
                background: #ff6633;
                color: white;
                font-size: 1.5em;
            }

        </style>
        <style>

            *,
            *::before,
            *::after {
                box-sizing: border-box;
            }

            body {
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                font-family: "Ubuntu", sans-serif;
            }

            a {
                text-decoration: none;
            }

            button {
                border: 0;
                outline: none;
                font-family: inherit;
                font-size: inherit;
                cursor: pointer;
            }

            .navbar {
                height: 90px;
                background-color: hsl(0, 0%, 10%);
                padding: 20px 40px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .navbar .logo i {
                color: #0aa5ff;
                font-size: 22px;
            }

            .navbar .logo a {
                font-size: 24px;
                font-weight: 700;
                color: white;
                margin-left: 12px;
            }

            .menu {
                display: flex;
                align-items: center;
                gap: 32px;
            }

            .menu-links {
                display: flex;
                gap: 24px;
                border-right: 1px solid #999999;
                padding-inline: 24px;
            }

            .menu-links a {
                font-weight: 500;
                color: #999999;
                padding: 8px 16px;
            }

            .menu-links a:hover {
                color: white;
            }

            .log-in {
                font-weight: 500;
                padding: 12px 22px;
                background-color: transparent;
                color: #999999;
                border-radius: 10px;
                border: 2px solid #0aa5ff;
                transition: 0.2s;
            }

            .log-in:hover {
                background-color: #0aa5ff;
                color: white;
            }

            .menu-btn {
                font-size: 32px;
                color: white;
                display: none;
                cursor: pointer;
            }

            @media (max-width: 53rem) {
                .menu {
                    display: none;
                }

                .menu-btn {
                    display: block;
                }
            }
            .logo-header img {
                width: 20%;
            }
        </style>
        <title>News Manager</title>
    </head>
    <body>
        <nav class="navbar">
            <div class="">
                <i class="fa-solid fa-font-awesome"></i>
                <a href="home">
 <div class="logo-header">
                    <img src="../img/OAS.png" alt="logo" />
                </div>                </a>
            </div>
            <div class="menu">
                <div class="menu-links">
                    <a href="ListNews">News Manager</a>
                </div>
                <a href="home"> <button class="log-in">Home</button></a>
            </div>
            <div class="menu-btn">
                <i class="fa-solid fa-bars"></i>
            </div>
        </nav>
        <h2>List of News</h2>
        <div class="toolbar">
            <div class="toolbar_right"> 
                <a href="AddNews"><button id="add-button">Add</button></a>
            </div>
        </div>
        <div class="container">

            <!-- Using grid to layout news items and buttons -->
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                <!-- Loop through each news item -->
                <c:forEach items="${news}" var="news">
                    <div class="bg-white p-6 rounded-lg shadow-md">
                        <strong>${news.getTitle()}</strong><br>
                        ${news.getDescription()}<br>
                        <em>Date: ${news.getDate()}</em><br>

                        <!-- Update and Delete buttons -->
                        <div class="flex justify-end mt-4">
                            <a href="UpdateNews?id=${news.getId()}">
                                <button class="btn mr-2">Update</button>
                            </a>
                            <form method="post" action="DeleteNews">
                                <input type="hidden" name="id" value="${news.getId()}"/>
                                <button type="submit" class="btn" onclick="return confirm('Are you sure you want to delete news ${news.getId()}')">Delete</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
