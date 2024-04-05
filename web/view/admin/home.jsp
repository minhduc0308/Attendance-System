<%-- 
    Document   : home
    Created on : Feb 29, 2024, 10:37:08 AM
    Author     : -MSI-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="../css/style.css" />
        <title>Assignment</title>
        <style>
            body {
                margin: 0;
                padding: 0;
            }
            header {
                color: black;
                margin: 10px;
                text-align: center;
                font-size: 1.8em;
                font-weight: thin;
            }
            .header-fpt {
                background-color: #f1f1f1;
                text-align: center;
                padding: 10px;
            }

            .logo-header img {
                width: 20%;
            }

            .main-body {
                width: 100%;
                padding-top: 20px;

            }

            #navbar {
                background-color: white;
                border-right: solid;
                border-color: rgba(0, 22, 22, 0.4);
                height: calc(100vh - 110px);
            }

            #navbar ul {
                height: 88%;
                padding: 0;
                overflow-y: auto;
                overflow-x: hidden;
            }

            #navbar li {
                color: #4d4e53;
                border-top: 1px solid;
                list-style: none;
                position: relative;
                width: 100%;
            }

            #navbar a {
                display: block;
                padding: 10px 30px;
                color: #4d4e53;
                text-decoration: none;
                cursor: pointer;
            }

            .main-controller {
                display: grid;
                grid-template-columns: 1fr 1fr 1fr;
                grid-area: content;
                padding: 30px;
                gap: 30px;
            }

            .main-controller .control-model {
                width: 100%;
                height: 150px;
                border: 1px solid #000;
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 30px;
                cursor: pointer;
            }

            .footer {
                background-color: #f1f1f1;
                width: 100%;
                height: 130px;
                text-align: center;
                padding: 20px;
            }
            .container-body {
                width: 100%;
                margin: 0;
                padding: 0;
            }

            .main-body {
                padding-top: 0;
            }

            .logout {
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                position: absolute;
                top: 10px;
                right: 50px;
            }

            .logout:hover::before {
                content: "Logout";
                position: absolute;
                top: 100%;
                left: 50%;
                transform: translateX(-50%);
                background-color: #333;
                color: white;
                padding: 5px;
                border-radius: 5px;
                opacity: 0;
                transition: opacity 0.3s;
            }

            .logout:hover::before {
                opacity: 1;
            }

            .footer {
                background-color: #ef9926;
                color: white;
                font-weight: bold;
                position: absolute;
                bottom: 0;
            }

        </style>

    </head>
    <body>
        <div class="container-body">
            <div class="header-fpt">
                <div class="logo-header">
                    <img src="../img/OAS.png" alt="logo" />
                </div>
                <div class="logout">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 512 512"
                        width="35"
                        height="35"
                        fill="#808080"
                        onclick="logout()"
                        >
                    <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
                    <path
                        d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"
                        />
                    </svg>
                </div>
            </div>
            
                <div class="main-body row">
                    <nav id="navbar" class="col-lg-3">
                        <header>ADMIN's Feature</header>
                        <ul>
                            <li><a class="nav-link" href="changepassword">Change PassWord</a></li>                       
                        </ul>
                    </nav>
                    <div class="main-controller col-lg-9">
                        <div class="control-model" onclick="manager(event)">
                            <a href="ListStudent">Student Manager</a>
                        </div>
                        <div class="control-model" onclick="manager(event)">
                            <a href="ListLecture">Lecture Manager</a>
                        </div>
                        <div class="control-model" onclick="manager(event)">
                            <a href="ListNews">New Manager</a>
                        </div>
                         <div class="control-model" onclick="manager(event)">
                            <a href="loadApp">View Applications</a>
                        </div>

                    </div>
                </div>
     


            <div class="footer">
                <p>FPT UNIVERSITY</p>
                <span>DAI HOC FPT HA NOI</span>
            </div>
        </div>

        <script>
            function logout() {
                window.location.href = '/testasm/logout';
            }

            function manager(event) {
                // Lấy ra phần tử đang được click
                var clickedElement = event.target;
                // Lấy nội dung của phần tử được click
                var elementContent = clickedElement.innerText;
                console.log(elementContent);
                // Thực hiện điều kiện tùy thuộc vào nội dung của phần tử được click
                switch (elementContent) {
                    case "Student":

                        window.location.href = "controlStudent"; // Chuyển hướng sang trang tương ứng cho phần tử 'a'
                        break;

                    case "Lecture":
                        window.location.href = "controlLecture"; // Chuyển hướng sang trang tương ứng cho phần tử 'b'
                        break;
                    case "Lecture Timetable":
                        window.location.href = "timetablelecture"; // Chuyển hướng sang trang tương ứng cho phần tử 'b'
                        break;
                        // Thêm các trường hợp khác tương ứng với các phần tử khác nếu cần
                    default:
                        // Thực hiện hành động mặc định nếu không phù hợp với bất kỳ trường hợp nào
                        break;
                }
            }
        </script>
    </body>
</html>

