package dal;

import java.math.BigDecimal;
import model.Lecture;

import java.math.BigInteger;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLecture extends DBContext {

    private String status = "Ok";

    public DAOLecture() {
        try {
            // Initialize the connection directly in the constructor
            Connection conn = getJDBCConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public int addLectureByPrepared(Lecture pro) {
        int n = 0;
        String sql = "INSERT INTO Lectures (idLectures, Email, LectureName, PhoneNumber, Address, DOB) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getJDBCConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setBigDecimal(1, new BigDecimal(pro.getIdLectures()));
            pre.setString(2, pro.getEmail());
            pre.setString(3, pro.getLectureName());
            pre.setInt(4, pro.getPhoneNumber());
            pre.setString(5, pro.getAddress());
            pre.setDate(6, pro.getDateOfBirth());
            // Execute the query
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateLecture(Lecture pro) {
        int n = 0;
        String sql = "UPDATE Lectures SET Email=?, LectureName=?, PhoneNumber=?, Address=?, DOB=? WHERE idLectures=?";
        try (Connection conn = getJDBCConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, pro.getEmail());
            pre.setString(2, pro.getLectureName());
            pre.setInt(3, pro.getPhoneNumber());
            pre.setString(4, pro.getAddress());
            pre.setDate(5, pro.getDateOfBirth());
            pre.setBigDecimal(6, new BigDecimal(pro.getIdLectures()));
            // Execute the query
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteLecture(BigInteger id) {
        int n = 0;
        String sql = "DELETE FROM Lectures WHERE idLectures=?";
        try (Connection conn = getJDBCConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setBigDecimal(1, new BigDecimal(id));
            // Execute the query
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Lecture> getData(String sql) {
        Vector<Lecture> vector = new Vector<>();
        try (Connection conn = getJDBCConnection();
             Statement state = conn.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = state.executeQuery(sql)) {

            while (rs.next()) {
                BigInteger id = rs.getBigDecimal(1).toBigInteger();
                String email = rs.getString(2);
                String lecname = rs.getString(3);
                int phone = rs.getInt(4);
                String address = rs.getString(5);
                Date dob = rs.getDate(6);

                Lecture pro = new Lecture(id, email, lecname, phone, address, dob);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOLecture.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOLecture dao = new DAOLecture();
    }
}
