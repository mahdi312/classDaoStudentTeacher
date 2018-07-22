package uni;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn = null;
    private static String url = "jdbc:mysql://127.0.0.1:3306/javadb?user=root";

    private DBConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }

    public static Connection Connect() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url);
        }
        return conn;
    }


}
