package DAO;

import LAB1.Courses;
import LAB2.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(String name, int credits) throws SQLException {
        String sql = "INSERT INTO courses (course_name, credits) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, credits);
            ps.executeUpdate();
        }
    }

    public List<Courses> getAllCourses() throws SQLException {
        List<Courses> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Courses(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits")));
            }
        }
        return list;
    }

    public void deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}