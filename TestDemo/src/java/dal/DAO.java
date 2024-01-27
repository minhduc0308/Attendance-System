/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.math.BigInteger;
import model.Student;
import java.sql.Connection;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import model.Admin;
import model.Lecture;
import model.Parent;

/**
 *
 * @author admin
 */
//private int id;
//    private String email;
//    private int ClassId;
//    private int phoneNumber;
//    private String address;
//    private Date dob;
//    private int TrainingId;
//    private int parentId;
public class DAO extends DBContext {

    private Connection conn;
    private String status = "Ok";
    private List<Student> std;
    private List<Parent> pa;
    private List<Lecture> le;
    public DAO() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public void loadAllStudent() {
        std = new Vector<Student>();
        String sql = "Select * from mydb9.students";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                std.add(new Student(
                        new BigInteger(rs.getString("idStudents")),
                        rs.getString("Email"),
                        rs.getInt("PhoneNumber"),
                        rs.getString("Address"),
                        rs.getDate("DOB")
                ));
            }
        } catch (Exception e) {
            status = "Error! Can not connect" + e.getMessage();
        }
    }
//    public Classes getClassById(int id){
//        String sql = "Select * from mydb9.class\n"
//                + "where idClass = ?;";
//        try {
//            PreparedStatement pre = conn.prepareCall(sql);
//            pre.setInt(1, id);
//            ResultSet rs = pre.executeQuery();
//            if(rs.next()){
//                Classes c = new Classes(rs.getInt(1), 
//                        rs.getString(2), 
//                        rs.getDate(3), 
//                        rs.getDate(4));
//                return c;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return null;
//    }

    public Student check(String email) {
        String sql = "SELECT idStudents, Email, PhoneNumber, Address, DOB FROM mydb9.students WHERE Email = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student s = new Student(
                        new BigInteger(rs.getString("idStudents")),
                        rs.getString("Email"),
                        rs.getInt("PhoneNumber"),
                        rs.getString("Address"),
                        rs.getDate("DOB")
                );
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void loadParent() {
        pa = new Vector<Parent>();
        String sql = "select * from mydb9.parent";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pa.add(new Parent(new BigInteger(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Parent checkPa(String userName, String pass) {
        String sql = "select * from mydb9.parent where Username = ? "
                + "and Pass = ?;";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, userName);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Parent pa = new Parent(new BigInteger(rs.getString("idParent")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Pass"),
                        rs.getString("Username"),
                        rs.getString("Job"),
                        rs.getString("PlaceOfWork"));
                return pa;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Parent checkPaForgotPassword(String userName, String email) {
        String sql = """
                     select * from mydb9.parent
                     where Username = ? and Email = ?;""";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, userName);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Parent pa = new Parent(new BigInteger(rs.getString("idParent")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Pass"),
                        rs.getString("Username"),
                        rs.getString("Job"),
                        rs.getString("PlaceOfWork"));
                return pa;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     public void updateOTPSentStatus(String username, boolean otpSent) {
    String sql = "UPDATE mydb9.parent SET otp_sent = ? WHERE Username = ?";

    try {
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setBoolean(1, otpSent);
        ps.setString(2, username);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
}
public void updatePassword(String username, String newPassword, BigInteger idParent) {
        String sql = "UPDATE mydb9.parent SET Pass = ? WHERE idParent = ? and Username = ?;";

        try{
            PreparedStatement preparedStatement = conn.prepareCall(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setBigDecimal(2, new BigDecimal(idParent));
            preparedStatement.setString(3, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
public BigInteger getIdParentByUsername(String username) {
        String sql = "SELECT idParent FROM mydb9.parent WHERE Username = ?";
        BigInteger idParent = null;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idParent = new BigInteger(resultSet.getString("idParent"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return idParent;
    }
    public void loadLecture(){
        le = new Vector<Lecture>();
        String sql = "select * from mydb9.lectures;";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs  = ps.executeQuery();
            while (rs.next()) {                
               le.add(new Lecture(new BigInteger(rs.getString(1)), 
                       rs.getString(2), 
                       rs.getString(3), 
                       rs.getInt(4), 
                       rs.getString(5), 
                       rs.getDate(6)));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Lecture checkLectureEmail(String email){
        String sql= "SELECT idLectures, Email, LectureName, PhoneNumber, "
                + "Address, DOB FROM mydb9.lectures WHERE Email = ?;";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lecture le = new Lecture(new BigInteger(rs.getString(1)), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getDate(6));
                return le;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Admin checkAdminEmal(String email){
        String sql = "select idAdmin, Email from mydb9.admin where Email = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Admin ad = new Admin(new BigInteger(rs.getString(1)),
                rs.getString(2));
                return ad;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Student> getStd() {
        return std;
    }

    public void setStd(List<Student> std) {
        this.std = std;
    }

    public List<Parent> getPa() {
        return pa;
    }

    public void setPa(List<Parent> pa) {
        this.pa = pa;
    }

    public List<Lecture> getLe() {
        return le;
    }

    public void setLe(List<Lecture> le) {
        this.le = le;
    }
    
    public static void main(String[] args) {
        DAO d = new DAO();

//    // Gọi hàm check với một địa chỉ email để kiểm tra
//    String emailToCheck = "ddominh16@gmail.com";
//    Student resultStudent = d.check(emailToCheck);
//
//    // Kiểm tra kết quả và hiển thị thông tin sinh viên nếu tìm thấy
//    if (resultStudent != null) {
//        System.out.println("Student found:");
//        System.out.println(resultStudent);
//    } else {
//        System.out.println("Student not found for email: " + emailToCheck);
//    }
//        d.loadParent();
//        for (Parent pa : d.getPa()) {
//            System.out.println(pa);
//        }
//       String user = "parent_user";
//       String pass = "password";
//       Parent rs = d.checkPa(user, pass);
//       if(rs != null){
//           System.out.println("ID: " + rs.getId());
//           System.out.println(rs);
//       }else{
//           System.out.println("not found");
//       }
//         String testUsername = "";
//        String testNewPassword = "new_password";
//        BigInteger testIdParent = new BigInteger("12345"); // Thay đổi giá trị theo idParent thực tế
//
//        try {
//            d.updatePassword(testUsername, testNewPassword, testIdParent);
//            System.out.println("Password updated successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Failed to update password. Error: " + e.getMessage());
//        }
       d.loadLecture();
        for (Lecture le : d.getLe()) {
            System.out.println(le);
        }
//        System.out.println(d.getIdParentByUsername("parent_user"));
    }
}
