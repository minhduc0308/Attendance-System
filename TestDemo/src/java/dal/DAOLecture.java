package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Lecture;

public class DAOLecture {

    private Connection connection;

    // Constructor that takes a database connection
    public DAOLecture(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new lecture to the database
    public void addLecture(Lecture lecture) {
        try {
            String query = "INSERT INTO lectures (idLectures, Email, PhoneNumber, Address, DateOfBirth) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, lecture.getIdLectures());
                preparedStatement.setString(2, lecture.getEmail());
                preparedStatement.setInt(3, lecture.getPhoneNumber());
                preparedStatement.setString(4, lecture.getAddress());
                preparedStatement.setDate(5, lecture.getDateOfBirth());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all lectures from the database
    public List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<>();
        try {
            String query = "SELECT * FROM lectures";
            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int idLectures = resultSet.getInt("idLectures");
                    String email = resultSet.getString("Email");
                    int phoneNumber = resultSet.getInt("PhoneNumber");
                    String address = resultSet.getString("Address");
                    Date dateOfBirth = resultSet.getDate("DateOfBirth");

                    Lecture lecture = new Lecture(idLectures, email, phoneNumber, address, dateOfBirth);
                    lectures.add(lecture);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    // Method to update an existing lecture in the database
    public void updateLecture(Lecture lecture) {
        try {
            String query = "UPDATE lectures SET Email=?, PhoneNumber=?, Address=?, DateOfBirth=? WHERE idLectures=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, lecture.getEmail());
                preparedStatement.setInt(2, lecture.getPhoneNumber());
                preparedStatement.setString(3, lecture.getAddress());
                preparedStatement.setDate(4, lecture.getDateOfBirth());
                preparedStatement.setInt(5, lecture.getIdLectures());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a lecture from the database
    public void deleteLecture(int lectureId) {
        try {
            String query = "DELETE FROM lectures WHERE idLectures=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, lectureId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to search for a lecture by ID

    public Lecture getLectureById(int lectureId) {
        try {
            String query = "SELECT * FROM lectures WHERE idLectures=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, lectureId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String email = resultSet.getString("Email");
                        int phoneNumber = resultSet.getInt("PhoneNumber");
                        String address = resultSet.getString("Address");
                        Date dateOfBirth = resultSet.getDate("DateOfBirth");

                        return new Lecture(lectureId, email, phoneNumber, address, dateOfBirth);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Additional methods can be added based on specific requirements
}
