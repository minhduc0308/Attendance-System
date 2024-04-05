<%-- 
    Document   : student
    Created on : Mar 12, 2024, 11:15:21 PM
    Author     : -MSI-
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Request</title>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script type="text/javascript">

            //Đảm bảo tất cả các phần tử trong trang được tải xong
            $(document).ready(function () {
                updateRequestList();
                // Mảng để lưu trữ các yêu cầu đã tạo
                var changeRequests = [];

                // Hàm để hiển thị form tạo yêu cầu
                function showRequestForm() {
                    $('#requestForm').show();
                }

                // Hàm để thêm yêu cầu vào bảng
                function addRequestToTable(course, fromStudent, toStudent) {
                    // Kiểm tra xem course đã tồn tại trong yêu cầu trước đó chưa
                    var exists = false;
                    $.each(changeRequests, function (index, request) {
                        if (request.course === course) {
                            exists = true;
                            return false; // Thoát khỏi vòng lặp khi tìm thấy course trùng
                        }
                    });

                    if (exists) {
                        alert('Không thể tạo yêu cầu cho cùng một course ' + course + '!');
                        return;
                    }
                    //Gọi AJAX để gửi yêu cầu đến máy chủ.
                    $.ajax({
                        type: 'POST',
                        url: 'change', // Địa chỉ của servlet nhận dữ liệu
                        data: {
                            action: 'findID',
                            course: course,
                            fromStudent: fromStudent

                        },
                        //Hàm được thực thi khi yêu cầu thành công.
                        success: function (response) {
                            const regex = /\d+/; // Matches one or more digits
                            const number = response.match(regex)[0];
                            console.log(course);
                            console.log(fromStudent);
                            // Thêm yêu cầu vào mảng
                            changeRequests.push({
                                cid: number,
                                course: course,
                                fromStudent: fromStudent,
                                toStudent: toStudent
                            });

                            // Hiển thị yêu cầu trên bảng, tạo ra một dòng mới
                            var newRow = '<tr><td>' + course + '</td><td>' + fromStudent + '</td><td>' + toStudent + '</td><input type="hidden" name="cid" value="' + number + '"><td><button class="cancelRequestButton">Hủy</button></td></tr>';


                            //  chọn phần tử có ID là changeRequestTable và thêm chuỗi HTML mới vào bên trong phần tử này
                            $('#changeRequestTable tbody').append(newRow);

                        },
                        error: function (xhr, status, error) {
                            alert('Đã có lỗi xảy ra khi lấy ID mới: ' + error);
                        }
                    });

                }

                // Sự kiện click cho nút tạo yêu cầu
                $('#createRequestButton').click(function () {
                    showRequestForm();
                });

                // Sự kiện click cho nút thêm yêu cầu
                $('#addRequestButton').click(function (event) {
                    var course = $('#course').val();
                    var fromStudent = $('#fromStudent').val();
                    var toStudent = $('#toStudent').val();

                    // Kiểm tra xem có ô input nào trống không
                    if (course === '' || fromStudent === '' || toStudent === '') {
                        alert('Vui lòng điền đầy đủ thông tin yêu cầu.');
                        return;
                    }

                    // Kiểm tra course đã tồn tại trong yêu cầu trước đó chưa
                    var exists = false;
                    $.each(changeRequests, function (index, request) {
                        if (request.course === course) {
                            exists = true;
                            return false; // Thoát khỏi vòng lặp khi tìm thấy course trùng
                        }
                    });

                    if (exists) {
                        alert('Không thể tạo yêu cầu cho cùng một course ' + course + '!');
                        event.preventDefault(); // Ngăn chặn hành động mặc định của form
                        return;
                    }



                    // Gửi dữ liệu tới servlet
                    $.ajax({
                        type: 'POST',
                        url: 'change', // Địa chỉ của servlet nhận dữ liệu
                        data: {
                            action: 'add',
                            course: course,
                            fromStudent: fromStudent,
                            toStudent: toStudent
                        },
                        success: function (data) {
                            //Thêm yêu cầu mới vào bảng
                            addRequestToTable(course, fromStudent, toStudent);

                        },
                        error: function (xhr, status, error) {
                            alert('Đã có lỗi xảy ra: ' + error);
                        }
                    });



                });

                // Sự kiện click cho nút Hủy
                $('#changeRequestTable').on('click', '.cancelRequestButton', function () {
                    var row = $(this).closest('tr');
                    var course = row.find('td:eq(0)').text(); // Lấy nội dung cột course của hàng đó
                    var fromStudent = row.find('td:eq(1)').text(); // Lấy nội dung cột fromStudent của hàng đó
                    var cid = row.find('input[name="cid"]').val(); // Lấy giá trị của input ẩn chứa id của yêu cầu

                    // Gửi dữ liệu tới servlet
                    $.ajax({
                        type: 'POST',
                        url: 'change', // Địa chỉ của servlet nhận dữ liệu
                        data: {
                            cid: cid,
                            action: 'cancel',
                            course: course,
                            fromStudent: fromStudent
                        },
                        success: function (response) {
                            // Xóa yêu cầu khỏi mảng và bảng
                            changeRequests = changeRequests.filter(function (request) {
                                return request.course !== course;
                            });
                            row.remove();
                            alert('Đã hủy yêu cầu thành công.');
                        },
                        error: function (xhr, status, error) {
                            alert('Đã có lỗi xảy ra: ' + error);
                        }
                    });


                });


                // Sự kiện submit cho form
                $('#changeRequestForm').submit(function (event) {
                    // Ngăn chặn duyệt yêu cầu và tải lại trang
                    event.preventDefault();
                });
                function updateRequestList() {
                    $.ajax({
                        type: "GET",
                        url: "changetostudent", // Đường dẫn đến servlet hoặc tệp xử lý yêu cầu AJAX
                        success: function (data) {
                            // Cập nhật danh sách yêu cầu trên trang
                            //Để convert data sang json 
                            var db = JSON.stringify(data);
                            //chuyển đỏi thành js, tạo ra 1 mảng js chứa dữ liệu json
                            var dataArray = JSON.parse(db);
                            //tìm tất cả các chuỗi tương ứng với các regex trong ngoặc , trả về 1 mảng chứa chuỗi json
                            var jsonArray = dataArray.match(/\[.*?\]/g);

                            // Chuyển đổi từng phần tử mảng JSON thành đối tượng JSON
                            var jsonDataArray = jsonArray.map(function (item) {
                                //Chuyển đổi chuỗi json thành js
                                return JSON.parse(item);
                            });

                            // Làm việc với 1 yêu cầu trong mỗi lần update
                            var firstElement = jsonDataArray[0];
//                            console.log(firstElement[0].fromGroup.course.code);
//
                            // Xóa danh sách yêu cầu hiện có trên trang, không để các giá trị cũ bị giữ lại
                            $('#changeRequestTable tbody').empty();
//
//                            // Duyệt qua từng phần tử trong mảng, mõi phần tử là 1 yêu cầu
                            //request là giá trị phần tử trong mảng
                            $.each(firstElement, function (index, request) {
                                var newRow = '<tr><td>' + request.fromGroup.course.code + '</td><td>' + request.fromStudent.name + '</td><td>' + request.toStudent.name + '</td><input type="hidden" name="cid" value="' + request.id + '"><td><button class="cancelRequestButton">Hủy</button></td></tr>';
                                //Thêm dòng mới vào cuối bảng
                                        $('#changeRequestTable tbody').append(newRow);
                            });
                        },
                        error: function (xhr, status, error) {
                            console.error("Error updating request list:", error);
                        }
                    });
                }
                setInterval(updateRequestList, 1000);

            });
        </script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }

            #container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }

            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            h2 {
                color: #333;
                margin-bottom: 20px;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th,
            td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #4CAF50;
                color: white;
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
            }

            button {
                background-color: #4CAF50;
                color: white;
                padding: 5px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-right: 10px;
            }

            button:hover {
                background-color: #45a049;
            }

            #requestForm {
                margin-top: 20px;
            }

            #changeRequestForm {
                display: flex;
                flex-wrap: wrap;
                margin-top: 20px;
            }

            #changeRequestForm label {
                flex-basis: 20%;
                margin-bottom: 10px;
            }

            #changeRequestForm input[type="text"],
            #changeRequestForm select {
                flex-basis: 80%;
                margin-bottom: 10px;
                padding: 5px;
            }

            #changeRequestForm button {
                flex-basis: 100%;
                margin-bottom: 10px;
            }

            #changeRequestTable {
                margin-top: 20px;
            }

            .cancelRequestButton {
                background-color: #f44336;
                color: white;
                padding: 5px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-right: 10px;
                margin-left: 10px;
            }

            .cancelRequestButton:hover {
                background-color: #da190b;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../homebutton.jsp"></jsp:include>
            <div id="container">
                <div class="header"></div>
                <h2>Change Request</h2>
                <button id="createRequestButton">Tạo Yêu Cầu</button>
                <div id="requestForm" style="display:none;">
                    <form id="changeRequestForm" method="post" action="change">
                        <label for="course">Course:</label>
                        <select id="course">
                        <c:forEach items="${requestScope.groups}" var="g" varStatus="loop">
                            <option value="${g.course.code}" data-group-value="${g.id}">${g.course.code}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label for="fromStudent">From Student:</label>
                    <input type="text" id="fromStudent" readonly="true" value="${requestScope.studentid}"><br>
                    <label for="toStudent">To Student:</label>
                    <input type="text" id="toStudent" required="true"><br>
                    <button id="addRequestButton">Thêm Yêu Cầu</button>
                </form>
            </div>
            <br>
            <table id="changeRequestTable" border="1">
                <thead>
                    <tr>
                        <th>Course</th>
                        <th>From Student</th>
                        <th>To Student</th>
                        <th></th> <!-- Cột cho nút Hủy -->
                    </tr>
                </thead>
                <tbody>
                    <!-- Các yêu cầu sẽ được thêm vào đây -->
                </tbody>

            </table>
        </div>
        <script>
            // Sự kiện change cho phần tử select
            $('#course').change(function () {
                // Lấy giá trị của tùy chọn được chọn
                var selectedOption = $(this).find('option:selected');
                var groupValue = selectedOption.data('group-value');

                // Cập nhật giá trị của ô input fromGroup
                $('#fromGroup').val(groupValue);
            });

        </script>
    </body>
</html>
