package LAB2;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
    Connection connection;
    public DatabaseConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "123");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }


}