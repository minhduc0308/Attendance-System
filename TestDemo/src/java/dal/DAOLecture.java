/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Lecture;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOLecture extends DBContext {

    private Connection conn;
    private String status = "Ok";
    

    public DAOLecture() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }


    public int addLectureByPrepared(Lecture pro) {
        int n = 0;
        String sql = "INSERT INTO [Lectures]\n"
                + "           ([idLectures]\n"
                + "           ,[Email]\n"
                + "           ,[LectureName]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Address]\n"
                + "           ,[DOB]\n"
                + "     VALUES(?,?,?,?,?,?)";
//         set para : ? start 1
//         pre.setDataType(indexOf?,para);
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pro.getIdLectures());
            pre.setString(2, pro.getEmail());
            pre.setString(3, pro.getLectureName());
            pre.setInt(4, pro.getPhoneNumber());
            pre.setString(5, pro.getAddress());
            pre.setDate(6, pro.getDateOfBirth());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public int updateLecture(Lecture pro) {
        int n = 0;
        String sql = "UPDATE [Lectures]\n"
                + "   SET [Email] =?"
                + "      ,[LectureName] = ?"
                + "      ,[PhoneNumber] = ?"
                + "      ,[Address] = ?"
                + "      ,[DOB] = ?"
                + " WHERE [idLectures] = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getEmail());
            pre.setString(2, pro.getLectureName());
            pre.setInt(3, pro.getPhoneNumber());
            pre.setString(4, pro.getAddress());
            pre.setDate(5, pro.getDateOfBirth());
            pre.setInt(6, pro.getIdLectures());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteLecture(int id) {
        int n = 0;
        String sql = "delete from Lectures where idLectures=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Lecture> getData(String sql) {
        Vector<Lecture> vector = new Vector<>();
        try {
//            synchronized
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1); 
                String email=rs.getString(2);
                String Lecname = rs.getString(3);
                int phone = rs.getInt(4);
                String address = rs.getString(5);
                Date DOB = rs.getDate(6);
          

                Lecture pro = new Lecture(id, email, Lecname, phone,address,
                DOB);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    
    public static void main(String[] args) {
        DAOLecture dao = new DAOLecture();
//        Customer pro = new Customer(501, "Garenth", "Wick",
//                "(235)363-3583", "wick.gath@gmail.com", "12 grove street", "Detroit",
//                "Texas", "92111");
//        int n = dao.addCustomerByPrepared(pro);
//        if (n == 1) {
//            System.out.println("inserted");
//        }

        Vector<Lecture> vector=dao.getData("select * from Lectures");
        for (Lecture customer : vector) {
            
            System.out.println(customer);
        }
    }

}
