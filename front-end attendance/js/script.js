// Đoạn mã JavaScript trong file script.js

document.addEventListener("DOMContentLoaded", function () {
    // Lấy tất cả các class card
    var classCards = document.querySelectorAll(".classcard");

    // Lặp qua từng class card và thêm sự kiện click
    classCards.forEach(function (classCard) {
        classCard.addEventListener("click", function () {
            // Lấy giá trị data-class của class card được click
            var selectedClass = this.getAttribute("data-class");

            // Hiển thị danh sách sinh viên tương ứng với lớp học được chọn
            showStudentList(selectedClass);
        });
    });

    // Hàm hiển thị danh sách sinh viên cho một lớp học cụ thể
    function showStudentList(selectedClass) {
        // Lấy tất cả các student details
        var allStudentDetails = document.querySelectorAll(".studentdetails");

        // Ẩn tất cả student details
        allStudentDetails.forEach(function (studentDetail) {
            studentDetail.style.display = "none";
        });

        // Hiển thị chỉ những student details của lớp học được chọn
        var selectedStudentDetails = document.querySelectorAll(
            '.studentdetails[data-class="' + selectedClass + '"]'
        );

        selectedStudentDetails.forEach(function (studentDetail) {
            studentDetail.style.display = "flex";
            studentDetail.style.justifyContent= "space-between";
        });
    }
});
