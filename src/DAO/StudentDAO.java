package DAO;

import LAB1.Student;
import LAB1.Undergraduate;
import LAB2.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE
    public void addStudent(String name, String email, double gpa) throws SQLException {
        String sql = "INSERT INTO students (student_name, email, gpa) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, gpa);
            ps.executeUpdate();
        }
    }

    // READ
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Undergraduate(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("gpa")));
            }
        }
        return list;
    }

    // DELETE
    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}