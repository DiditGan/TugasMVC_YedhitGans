package Model;

import java.sql.*;

public class Connector {
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_NAME = "upnvy";
    private static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static String DB_USERNAME = "root";
    private static String DB_PASSWORD = "";

    static Connection connection;
    
    public static Connection connect() {
        try {
            Class.forName(JDBC_DRIVER);
            
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Connection Gagal: " + exception.getLocalizedMessage());
        }
        return connection;
    }
}
