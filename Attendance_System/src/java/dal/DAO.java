/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import entity.Student;
import java.sql.Connection;
import java.sql.*;
import java.util.List;
import java.util.Vector;

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
public class DAO {
    private Connection conn;
    private String status="Ok";
    private List<Student>std;
    public DAO(){
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection"+e.getMessage();
        }
    }
    public void loadAllStudent(){
        std = new Vector<Student>();
        String sql = "Select * from mydb9.students";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int studentId = rs.getInt(1);
                String email = rs.getString(2);
                int phoneNumber = rs.getInt(3);
                String address= rs.getString(4);
                Date dob = rs.getDate(5);
                std.add(new Student(studentId, email, phoneNumber, address, dob));
            }
        } catch (Exception e) {
            status = "Error! Can not connect" + e.getMessage();
        }
    }
    
    public Student check(String email){
        String sql = "select Email \n"
                + "from mydb9.students\n"
                + "where Email = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Student s = new Student(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getString(4), 
                        rs.getDate(5));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public List<Student> getStd() {
        return std;
    }

    public void setStd(List<Student> std) {
        this.std = std;
    }
    public static void main(String[] args) {
        DAO d = new DAO();
        d.loadAllStudent();
        for(Student student : d.getStd()){
            System.out.println(student);
        }
    }
}
