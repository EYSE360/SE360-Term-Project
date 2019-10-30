import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost/se360", "root", "mybeteth");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
