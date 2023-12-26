package ls10.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private DatabaseUtils() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(ls10.lab.util.AppConstant.MYSQL_URL,
                ls10.lab.util.AppConstant.MYSQL_USERNAME, ls10.lab.util.AppConstant.MYSQL_PASS);
    }
}
