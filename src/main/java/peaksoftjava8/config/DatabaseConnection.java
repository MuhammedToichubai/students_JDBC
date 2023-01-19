package peaksoftjava8.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mukhammedasantegin
 * @project_name students_JDBC
 */
public class DatabaseConnection {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java8",
                    "postgres",
                    "yiman"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
