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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Admin;
import model.Classes;
import model.Feedback;
import model.Lecture;
import model.Parent;
import model.TrainigDepartment;

/**
 *
 * @author admin
 */

public class DAO extends DBContext {

    private String status = "Ok";
    private List<Student> std;
    private List<Parent> pa;
    private List<Lecture> le;

      public List<Student> loadAllStudent() {
        std = new Vector<Student>();
        String sql = "SELECT * FROM [dbo].[Student]";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                String email = rs.getString(4);
                String imgUrl = rs.getString(5);
                String username = rs.getString(6);
                std.add(new Student(id, name, dob, email, imgUrl,username));
            }
        } catch (Exception e) {
            status = "Error! Can not connect" + e.getMessage();
        }
        return std;
    }
    public void addStudent(BigInteger id, String email, int phoneNumber, String address, Date dob) {
        try {
            String sql = "INSERT INTO mydb9.students (idStudents, Email, PhoneNumber, Address, DOB) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id.toString());
            pre.setString(2, email);
            pre.setInt(3, phoneNumber);
            pre.setString(4, address);
            pre.setDate(5, dob);
            pre.executeUpdate();
        } catch (SQLException e) {
            status = "Error! Can not connectionect: " + e.getMessage();
        }
    }

    public Classes getClassById(int id) {
        String sql = "Select * from mydb9.class\n"
                + "where idClass = ?;";
        try {
            PreparedStatement pre = connection.prepareCall(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Classes c = new Classes(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4));
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

   public Student check(String email) {
    String sql = "SELECT id, [name], dob, email, imgUrl, userName FROM Student WHERE email = ?;";

    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            Student s = new Student(
                rs.getString("id"),
                rs.getString("name"),
                rs.getDate("dob"),
                rs.getString("email"),
                rs.getString("imgUrl"),
                rs.getString("username")
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
            PreparedStatement ps = connection.prepareCall(sql);
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

    public void addParent(Parent parent) {
        String sql = "INSERT INTO `mydb32`.`parent`\n"
                + "(`idParent`,\n"
                + "`Name`,\n"
                + "`Address`,\n"
                + "`Email`,\n"
                + "`Pass`,\n"
                + "`Username`,\n"
                + "`Job`,\n"
                + "`PlaceOfWork`,\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setBigDecimal(1, new BigDecimal(parent.getId()));
            pre.setString(2, parent.getName());
            pre.setString(3, parent.getAdd());
            pre.setString(4, parent.getEmail());
            pre.setString(5, parent.getPass());
            pre.setString(6, parent.getUserName());
            pre.setString(7, parent.getJob());
            pre.setString(8, parent.getPlaceOfWork());
            pre.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Parent checkPa(String userName, String pass) {
        String sql = "select * from mydb9.parent where Username = ? "
                + "and Pass = ?;";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
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
            PreparedStatement ps = connection.prepareCall(sql);
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
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setBoolean(1, otpSent);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePassword(String username, String newPassword, BigInteger idParent) {
        String sql = "UPDATE mydb9.parent SET Pass = ? WHERE idParent = ? and Username = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareCall(sql);
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

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

    public void loadLecture() {
    le = new Vector<>();
    String sql = "SELECT id, [name], dob, email, username FROM Lecture;";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Lecture lecture = new Lecture(
                rs.getString("id"),
                rs.getString("name"),
                rs.getDate("dob"),
                rs.getString("email"),
                rs.getString("username")
            );
            le.add(lecture);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
}


    public void addLecture(BigInteger idLectures, String email, String lectureName, int phoneNumber, String address, Date dateOfBirth) {
        try {
            String sql = "INSERT INTO mydb9.students (idStudents, Email, PhoneNumber, Address, DOB) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, idLectures.toString());
            pre.setString(2, email);
            pre.setInt(3, phoneNumber);
            pre.setString(4, address);
            pre.setDate(5, dateOfBirth);
            pre.executeUpdate();
        } catch (SQLException e) {
            status = "Error! Can not connectionect: " + e.getMessage();
        }
    }

   public Lecture getLectureById(String id) {
    Lecture lecture = null;
    try {
        String sql = "SELECT * FROM Lecture WHERE id = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, id);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            Date dob = rs.getDate("dob");
            String email = rs.getString("email");
            String username = rs.getString("username");

            lecture = new Lecture(id, name, dob, email, username);
        }
    } catch (SQLException e) {
        status = "Error! Can not connect: " + e.getMessage();
    }
    return lecture;
}


  public Lecture checkLectureEmail(String email) {
    String sql = "SELECT id, [name], dob, email, username FROM Lecture WHERE email = ?;";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Lecture lecture = new Lecture(
                rs.getString("id"),
                rs.getString("name"),
                rs.getDate("dob"),
                rs.getString("email"),
                rs.getString("username")
            );
            return lecture;
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return null;
}


    public Admin checkAdminEmal(String email) {
        String sql = "select idAdmin, Email from mydb9.admin where Email = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin ad = new Admin(new BigInteger(rs.getString(1)),
                        rs.getString(2));
                return ad;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public TrainigDepartment checkTrainEmail(String email){
        String sql = "select idTrainingDepartment, PhoneNumber, Email from trainingdepartment where Email = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TrainigDepartment train = new TrainigDepartment(rs.getString(1), rs.getInt(2), rs.getString(3));
                return train;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void sendFeedback(Feedback fe){
        String sql = "INSERT INTO Feedback (Content, StudentID, "
                + "LectureID, Date) VALUES (?, ?, ?,CURRENT_TIMESTAMP);";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, fe.getContent());
            ps.setString(2, fe.getStudentId());
            ps.setString(3, fe.getLectureId());
            ps.executeUpdate();
            System.out.println("Feedback thanh cong!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<String[]> getClassNameByLectureId(String lectureId){
        String sql = "select la.GroupId, gr.[name]\n"
                + "from dbo.LectureAsignment la\n"
                + "inner join dbo.[Group] gr on la.GroupId = gr.id\n"
                + "where la.LectureId = ?;";
         ArrayList<String[]> classNames = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, lectureId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String[] classInfo = new String[2];
                classInfo[0] = rs.getString("GroupId");
                classInfo[1] = rs.getString("name");
                classNames.add(classInfo);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return classNames;
    }
    public ArrayList<Student> getStudentIdsByClassId(int classId, String lecturedId) {
    ArrayList<Student> students = new ArrayList<>();
        String sql = "select st.id, st.[name]\n"
                + "from dbo.Student st\n"
                + "inner join dbo.[Group] gr on gr.id = st.GroupId\n"
                + "inner join dbo.LectureAsignment le on le.GroupId = st.GroupId\n"
                + "where st.GroupId = ? and le.LectureId = ?;";

    try {
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1, classId);
        pre.setString(2, lecturedId);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            students.add(student);
        }
    } catch (Exception e) {
        System.out.println("Error! Can not connect" + e.getMessage());
    }

    return students;
}

    public List<Feedback> getFeedbackByStudentId(String studentId, String lectureId){
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "select fe.idFeedBack, fe.StudentId, fe.Content, fe.DATE\n"
                + "from dbo.Feedback fe\n"
                + "inner join dbo.Lecture le on le.id = fe.LectureId\n"
                + "inner join dbo.Student st on st.id = fe.StudentId\n"
                + "where fe.StudentId = ? and fe.LectureId = ?;";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, studentId);
            ps.setString(2, lectureId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Feedback fe = new Feedback();
                fe.setId(rs.getInt("idFeedBack"));
                fe.setStudentId(rs.getString("StudentId"));
                fe.setContent(rs.getString("Content"));
                java.sql.Date date = rs.getDate("Date");
                fe.setDate(date);
                feedbackList.add(fe);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return feedbackList;
    }
    
    public List<Feedback> getFeedbackByLectureId(String studentId, String lectureId){
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "select fe.idFeedBack, fe.LectureId, le.[name], fe.Content, fe.DATE\n"
                + "from dbo.Feedback fe\n"
                + "inner join dbo.Lecture le on le.id = fe.LectureId\n"
                + "inner join dbo.Student st on st.id = fe.StudentId\n"
                + "where fe.StudentId = ? and fe.LectureId = ?;";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, studentId);
            ps.setString(2, lectureId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Feedback fe = new Feedback();
                fe.setId(rs.getInt("idFeedBack"));
                fe.setLectureId(rs.getString("lectureId"));
                Lecture le = getLectureById1(lectureId);
                fe.setLecture(le);
                fe.setContent(rs.getString("Content"));
                java.sql.Date date = rs.getDate("Date");
                fe.setDate(date);
                feedbackList.add(fe);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return feedbackList;
    }
    public Lecture getLectureById1(String id) {
        String sql = "SELECT * FROM Lecture WHERE id = ?";
    try {
        
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1, id);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            Lecture le = new Lecture(rs.getString("id"), 
                    rs.getString("name"), 
                    rs.getDate("dob"), 
                    rs.getString("email"), 
                    rs.getString("userName"));
            return le;
        }
    } catch (SQLException e) {
        status = "Error! Can not connect: " + e.getMessage();
    }
    return null;
}
    public ArrayList<Lecture> getLectureByStudentId(String studentId){
        ArrayList<Lecture> lecture = new ArrayList<>();
        String sql = "select lec.id, lec.[name]\n"
                + "from dbo.Student st\n"
                + "inner join dbo.[Group] gr on gr.id = st.GroupId\n"
                + "inner join dbo.LectureAsignment le on le.GroupId = st.GroupId\n"
                + "inner join dbo.Lecture lec on lec.id = le.LectureId\n"
                + "where st.id = ?;";
        try {
            PreparedStatement pre = connection.prepareCall(sql);
            pre.setString(1, studentId);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Lecture le = new Lecture();
                le.setId(rs.getString("id"));
                le.setName(rs.getString("name"));
                lecture.add(le);
            }
        } catch (Exception e) {
        }
        return lecture;
    }
    public void updateFeedback(String content, String studentId, String lectureId, int idFeedback){
        String sql = "UPDATE feedback "
                     + "SET Content = ?, "
                     + "Date = CURRENT_TIMESTAMP "
                     + "WHERE StudentId = ? AND LectureId = ? AND idFeedBack = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, content);
            ps.setString(2, studentId);
            ps.setString(3, lectureId);
            ps.setInt(4, idFeedback);
             int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Feedback updated successfully!");
            } else {
                System.out.println("Failed to update feedback.");
            }
        } catch (Exception e) {
        }
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
        String studentId = "he1";
        String lectureId = "1";
        List<Feedback> feedbackList = d.getFeedbackByLectureId(studentId, lectureId);

    // In thông tin của các phản hồi
    for (Feedback feedback : feedbackList) {
        Lecture lecture = feedback.getLecture();
        System.out.println("Feedback ID: " + feedback.getId() + ", Lecture ID: " + feedback.getLectureId() + ", Lecture Name: " + lecture.getName()+
                ", Content: " + feedback.getContent() + ", Date: " + feedback.getDate());
        
        
    }
    }
}
