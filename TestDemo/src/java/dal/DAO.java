/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.math.BigInteger;
import model.Student;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Parent;
import model.Room;
import model.Session;
import model.TimeSlot;

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

    public DAO() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public Vector<Student> loadAllStudent() {
    Vector<Student> std = new Vector<>();
    String sql = "Select * from mydb32.students";
    try {
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            std.add(new Student(
                    new BigInteger(rs.getString("idStudents")),
                    rs.getString("Email"),
                    rs.getInt("ClassId"),
                    rs.getInt("PhoneNumber"),
                    rs.getString("Address"),
                    rs.getDate("DOB"),
                    rs.getInt("TrainingDId"),
                    rs.getInt("ParentId2")
            ));
        }
    } catch (Exception e) {
        status = "Error! Can not connect" + e.getMessage();
    }
    return std; // Return the Vector<Student> here
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
        String sql = "SELECT idStudents, Email, PhoneNumber, Address, DOB FROM mydb32.students WHERE Email = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student s = new Student(
                        new BigInteger(rs.getString("idStudents")),
                        rs.getString("Email"),
                    rs.getInt("ClassId"),
                    rs.getInt("PhoneNumber"),
                    rs.getString("Address"),
                    rs.getDate("DOB"),
                    rs.getInt("TrainingDId"),
                    rs.getInt("ParentId2")
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
        String sql = "select * from mydb32.parent";
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
        String sql = "select * from mydb32.parent where Username = ? "
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
    
    public ArrayList<Session> getSessions(int LectureId) {
        String sql = "SELECT "
                + "cs.idClassSession, "
                + "cs.Date, "
                + " cs.Status, "
                + "c.idClass, "
                + "c.Name AS ClassName, "
                + "c.StartDate, "
                + "c.EndDate, "
                + "s.idSubject, "
                + "s.SubjectName, "
                + "r.rid, "
                + "r.rname, "
                + "t.tid, "
                + " t.description, "
                + "FROM "
                + " ClassSession cs "
                + "INNER JOIN "
                + "Class c ON cs.ClassId = c.idClass "
                + "INNER JOIN "
                + "  Subject s ON s.idSubject = c.idSubject "
                + "INNER JOIN "
                + "Room r ON cs.rid = r.rid "
                + "INNER JOIN "
                + "TimeSlot t ON cs.tid = t.tid "
                + "WHERE "
                + "cs.LectureId = ?";
        ArrayList<Session> sessions = new ArrayList<>();

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, LectureId);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Session session = new Session();
                session.setDate(rs.getDate("Date"));
                session.setStatus(rs.getBoolean("Status"));
                session.setId(rs.getInt("idClassSession"));

                Room r = new Room();
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));
                session.setRoom(r);

                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                session.setSlot(t);

                sessions.add(session);
            }
        } catch (Exception e) {
            status = "Error! Can not connect" + e.getMessage();
        }
        System.out.println(sessions.size());
        return sessions;
    }

    public ArrayList<TimeSlot> all() {
        ArrayList<TimeSlot> slots = new ArrayList<>();

        try {
            String sql = "SELECT [tid]\n"
                    + "      ,[description]\n"
                    + "  FROM [TimeSlot]";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TimeSlot d = new TimeSlot();
                d.setId(rs.getInt("tid"));
                d.setDescription(rs.getString("description"));
                slots.add(d);
            }
        } catch (Exception e) {
            status = "Error! Can not connect" + e.getMessage();
        }
        return slots;

    }
    public Vector<Student> getData(String sql) {
        Vector<Student> vector = new Vector<>();
        try (Connection conn = getJDBCConnection();
             Statement state = conn.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = state.executeQuery(sql)) {

            while (rs.next()) {
                BigInteger id = rs.getBigDecimal(1).toBigInteger();
                String email = rs.getString(2);
                int classId = rs.getInt(3);
                int phone = rs.getInt(4);
                String address = rs.getString(5);
                Date dob = rs.getDate(6);
                int trainingId = rs.getInt(7);
                int parentId = rs.getInt(8);

                Student pro = new Student(id, email, classId, phone, address, dob,trainingId,parentId);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
    public Parent checkPaForgotPassword(String userName, String email) {
        String sql = "select * from mydb32.parent\n"
                + "where Username = ? and Email = ?;";
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
    String sql = "UPDATE mydb32.parent SET otp_sent = ? WHERE Username = ?";

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
        String sql = "UPDATE mydb32.parent SET Pass = ? WHERE idParent = ? and Username = ?;";

        try{
            PreparedStatement preparedStatement = conn.prepareCall(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setBigDecimal(2, new BigDecimal(idParent));
            preparedStatement.setString(3, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ tùy theo yêu cầu của bạn, ví dụ: logging hoặc throwing exception
        }
    }
public BigInteger getIdParentByUsername(String username) {
        String sql = "SELECT idParent FROM mydb32.parent WHERE Username = ?";
        BigInteger idParent = null;

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idParent = new BigInteger(resultSet.getString("idParent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ tùy theo yêu cầu của bạn
        }

        return idParent;
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
       
        System.out.println(d.getIdParentByUsername("parent_user"));
    }
}
