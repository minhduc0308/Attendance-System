/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Semester;
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
public class DAOSemester extends DBContext {

    private Connection conn;
    private String status = "Ok";

    public DAOSemester() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public int addSemesterByPrepared(Semester pro) {
        int n = 0;
        String sql = "INSERT INTO [Semester]\n"
                + "           ([idSemester]\n"
                + "           ,[Name]\n"
                + "     VALUES(?,?)";
//         set para : ? start 1
//         pre.setDataType(indexOf?,para);
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pro.getIdSemester());
            pre.setString(2, pro.getName());
           

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSemester.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public int updateSemester(Semester pro) {
        int n = 0;
        String sql = "UPDATE [Semester]\n"
                + "   SET [Name] =?"
                + " WHERE [idSemester] = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pro.getIdSemester());
            pre.setString(2, pro.getName());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteSemester(int id) {
        int n = 0;
        String sql = "delete from Semester where idSemester=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSemester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Semester> getData(String sql) {
        Vector<Semester> vector = new Vector<>();
        try {
//            synchronized
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int Semesterid = rs.getInt(1);
                String Name = rs.getString(2);
               
               

                Semester pro = new Semester(Semesterid, Name);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOSemester.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOSemester dao = new DAOSemester();
//        Customer pro = new Customer(501, "Garenth", "Wick",
//                "(235)363-3583", "wick.gath@gmail.com", "12 grove street", "Detroit",
//                "Texas", "92111");
//        int n = dao.addCustomerByPrepared(pro);
//        if (n == 1) {
//            System.out.println("inserted");
//        }

        Vector<Semester> vector = dao.getData("select * from Semester");
        for (Semester Semester : vector) {

            System.out.println(Semester);
        }
    }

}
