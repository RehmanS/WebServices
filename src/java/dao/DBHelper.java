package dao;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBHelper {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/restdb";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, username, password);
        return c;

    }

}
