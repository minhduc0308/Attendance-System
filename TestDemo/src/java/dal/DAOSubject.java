/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Subject;
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
public class DAOSubject extends DBContext {

    private Connection conn;
    private String status = "Ok";
    

    public DAOSubject() {
        try {
            conn = new DBContext().getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }


    public int addSubjectByPrepared(Subject pro) {
        int n = 0;
        String sql = "INSERT INTO [Subject]\n"
                + "           ([idSubject]\n"
                + "           ,[SubjectName]\n"
                + "           ,[TraingDepartmentId]\n"
                + "     VALUES(?,?,?)";
//         set para : ? start 1
//         pre.setDataType(indexOf?,para);
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pro.getIdSubject());
            pre.setString(2, pro.getSubjectName());
          
            pre.setInt(3, pro.getTraingDepartmentId());
          
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public int updateSubject(Subject pro) {
        int n = 0;
        String sql = "UPDATE [Subject]\n"
                + "   SET [SubjectName] =?"
                + "      ,[TraingDepartmentId] = ?"
                + " WHERE [idSubject] = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getSubjectName());
         
            pre.setInt(2, pro.getTraingDepartmentId());
            pre.setInt(3, pro.getIdSubject());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteSubject(int id) {
        int n = 0;
        String sql = "delete from Subject where idSubject=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Subject> getData(String sql) {
        Vector<Subject> vector = new Vector<>();
        try {
//            synchronized
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int idSubject = rs.getInt(1); 
              
                String SubjectName = rs.getString(2);
                int TraingDepartmentId = rs.getInt(3);
                
          

                Subject pro = new Subject(idSubject, SubjectName, TraingDepartmentId);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOSubject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    
    public static void main(String[] args) {
        
    }

}
