/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Class;
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
public class DAOClass extends DBContext {

    private Connection conn;
    private String status = "Ok";

    public DAOClass() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public int addClassByPrepared(Class pro) {
        int n = 0;
        String sql = "INSERT INTO [Class]\n"
                + "           ([idClass]\n"
                + "           ,[Name]\n"
                + "           ,[StartDate]\n"
                + "           ,[EndDate]\n"
                + "           ,[TrainingDeapartmentId]\n"
                + "     VALUES(?,?,?,?,?)";
//         set para : ? start 1
//         pre.setDataType(indexOf?,para);
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pro.getIdClass());
            pre.setString(2, pro.getName());
            pre.setDate(3, pro.getStartDate());
            pre.setDate(4, pro.getEndDate());
            pre.setInt(5, pro.getTrainingDeapartmentId());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public int updateClass(Class pro) {
        int n = 0;
        String sql = "UPDATE [Class]\n"
                + "   SET [Name] =?"
                + "      ,[StartDate] = ?"
                + "      ,[EndDate] = ?"
                + "      ,[TrainingDeapartmentId] = ?"
                + " WHERE [idClass] = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getName());
            pre.setDate(2, pro.getStartDate());
            pre.setDate(3, pro.getEndDate());
            pre.setInt(4, pro.getTrainingDeapartmentId());
            pre.setInt(5, pro.getIdClass());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteClass(int id) {
        int n = 0;
        String sql = "delete from Class where idClass=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Class> getData(String sql) {
        Vector<Class> vector = new Vector<>();
        try {
//            synchronized
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int Classid = rs.getInt(1);
                String Name = rs.getString(2);
                Date StartDate = rs.getDate(3);
                 Date EndDate = rs.getDate(4);
                int TDid = rs.getInt(5);
               

                Class pro = new Class(Classid, Name, StartDate, EndDate, TDid);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOClass dao = new DAOClass();
//        Customer pro = new Customer(501, "Garenth", "Wick",
//                "(235)363-3583", "wick.gath@gmail.com", "12 grove street", "Detroit",
//                "Texas", "92111");
//        int n = dao.addCustomerByPrepared(pro);
//        if (n == 1) {
//            System.out.println("inserted");
//        }

        Vector<Class> vector = dao.getData("select * from Class");
        for (Class Class : vector) {

            System.out.println(Class);
        }
    }

}
