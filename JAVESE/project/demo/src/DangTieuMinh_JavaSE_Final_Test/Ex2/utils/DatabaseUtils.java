package DangTieuMinh_JavaSE_Final_Test.Ex2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(AppConstant.MYSQL_URL,AppConstant.MYSQL_USERNAME,AppConstant.MYSQL_PASS);
    }
}
