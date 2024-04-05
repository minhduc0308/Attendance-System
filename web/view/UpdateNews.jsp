<%-- 
    Document   : UpdateNews
    Created on : Mar 29, 2024, 9:31:31 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.0.2/tailwind.min.css">
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            h1 {
                font-family: 'Poppins', sans-serif;
                color: #333;
                text-align: center;
                font-size: 36px;
                margin-bottom: 20px;
            }

            form {
                max-width: 400px;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            form input {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                box-sizing: border-box;
                border: 1px solid #ccc; /* Màu viền */
                border-radius: 5px; /* Đường cong viền */
            }

            form input[type="submit"] {
                background-color: #4caf50;
                color: #fff;
                cursor: pointer;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                padding: 10px;
            }

            form input[type="submit"]:hover {
                background-color: #45a049;
            }

            /* Add more styles if needed */

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
            textarea {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                box-sizing: border-box;
                border: 1px solid #ccc; /* Màu viền */
                border-radius: 5px; /* Đường cong viền */
                resize: vertical; /* Cho phép chỉnh kích thước theo chiều dọc */
            }

        </style>
        <title>Add News</title>
    </head>
    <script>
        function validateForm() {
            var title = document.getElementById("title").value;
            var description = document.getElementById("description").value;

            if (title.length > 100) {
                alert("Title cannot exceed 00 characters.");
                return false;
            }

            if (description.length > 500) {
                alert("Description cannot exceed 500 characters.");
                return false;
            }

            return true; // Nếu không có lỗi, cho phép form được gửi đi
        }

        function checkTitleLength() {
            var title = document.getElementById("title").value;
            if (title.length > 100) {
                alert("Title cannot exceed 100 characters.");
                return false;
            }
            return true;
        }

        function checkDescriptionLength() {
            var description = document.getElementById("description").value;
            if (description.length > 500) {
                alert("Description cannot exceed 500 characters.");
                return false;
            }
            return true;
        }
    </script>
    <body>
        <nav class="navbar">
            <div class="">
                <i class="fa-solid fa-font-awesome"></i>
                <a href="home">
                    <img src="https://scontent.fhan2-4.fna.fbcdn.net/v/t1.15752-9/429122120_371367415683940_1227749304622241657_n.png?_nc_cat=100&ccb=1-7&_nc_sid=8cd0a2&_nc_eui2=AeHWaRnl9Wao6BZVgJmEE6GliSCg-Ks2z4SJIKD4qzbPhHvFwKnBKMCkQbZvhexn5-jDmGZeml1efPdtRbhyo6MZ&_nc_ohc=QTEKgxN2dE0AX_M-yCV&_nc_ht=scontent.fhan2-4.fna&oh=03_AdQ4VUozaESvFAVXjY-FEzX_GvdiL5vjx9_KiBsLQSXupA&oe=66051A69" alt="Girl in a jacket" style="width:70px;height:60px;">
                </a>
            </div>
            <div class="menu">
                <div class="menu-links">
                    <a href="ListNews">News Manager</a>
                </div>
                <a href="../LogOut"> <button class="log-in">Log Out</button></a>
            </div>
            <div class="menu-btn">
                <i class="fa-solid fa-bars"></i>
            </div>
        </nav>
        <br>
        <h1>Update News</h1>
        <form action="UpdateNews" method="post" onsubmit="return validateForm()">
            <label for="title">ID:</label><br>
            <input type="text" id="id" name="id" value="${news.id}" readonly><br>

            <label for="title">Title:</label><br>
            <input type="text" id="title" name="title" value="${news.title}" required onblur="checkTitleLength()"><br>

            <label for="description">Description:</label><br>
            <textarea id="description" name="description" required onblur="checkDescriptionLength()">${news.description}</textarea><br>

            <label for="date">Date:</label><br>
            <input type="date" id="date" name="date" required value="${news.date}"><br><br>

            <input type="submit" value="Update News">
        </form>
    </body>
</html>
