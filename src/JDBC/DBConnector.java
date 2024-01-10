package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
        String user = "daul"; // 데이터베이스 사용자 이름
        String password = "1234"; // 데이터베이스 비밀번호

        return DriverManager.getConnection(url, user, password);
    }
}
