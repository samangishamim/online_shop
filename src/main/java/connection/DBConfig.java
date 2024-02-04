package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static Connection connection = null;

    public DBConfig() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/shop";
            String userName = "postgres";
            String passwrod = "shamim1379";
            try {
                connection = DriverManager.getConnection(url, userName, passwrod);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
