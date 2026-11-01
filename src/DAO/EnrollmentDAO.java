package DAO;

import LAB2.DatabaseConnection;

import java.sql.*;

public class EnrollmentDAO {
    public void enroll(int studentId, int courseId) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        }
    }

    public void updateEnrollment(int enrollmentId, int newCourseId) throws SQLException {
        String sql = "UPDATE enrollments SET course_id = ? WHERE enrollment_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newCourseId);
            ps.setInt(2, enrollmentId);
            ps.executeUpdate();
        }
    }

    public void deleteEnrollment(int enrollmentId) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE enrollment_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, enrollmentId);
            ps.executeUpdate();
        }
    }

    public void printStudentsWithCourses() throws SQLException {
        String sql = """
                SELECT e.enrollment_id, s.student_name, c.course_name
                FROM enrollments e
                JOIN students s ON e.student_id = s.student_id
                JOIN courses c ON e.course_id = c.course_id
                ORDER BY s.student_name
                """;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Enrollment"
                        + rs.getInt("enrollment_id") + ": "
                        + rs.getString("student_name") + " -> "
                        + rs.getString("course_name"));
            }
        }
    }
}