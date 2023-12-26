package Lab11.connect;

import Lab10.lab.exception.InvalidInputException;
import Lab11.model.ChungNhan;
import Lab11.model.ChuyenBay;
import Lab11.model.MayBay;
import Lab11.model.NhanVien;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysqlHangKhong {
    public class ConnectJDBC {

        private String hostName = "localhost:8082";
        private String dbName = "my_database";
        private String username = "root";
        private String password = "12345678";

        private String connectionURL = "jdbc:mysql://localhost:3306/maybay";

        public Connection connect(){
            //Tạo đối tượng Connection
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(connectionURL, username, password);
                System.out.println("Kết nối thành công");
            } catch (InvalidInputException e) {
                System.out.println("Kết nối không thành công");
                e.printStackTrace();
            }

            return conn;
        }
    }

}

