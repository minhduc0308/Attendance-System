/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBContext {
    public Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/mydb9";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            System.out.println("Ket noi thanh cong" + new DBContext().getJDBCConnection());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
