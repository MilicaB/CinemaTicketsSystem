package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//connection encapulated in Singleton class

public class DBConnection {

    private static DBConnection connectionInstance = null;
    private static Connection connection = null;

    private static final String DB_PASSWORD = "root";
    private static final String DB_USER = "root";
    private static final String DATABASE = "cinema_db";
    private static final String DB_HOST = "localhost:3306";

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBConnection.connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DATABASE
                    + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false", DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() {
        synchronized (DBConnection.class) {
            if (connectionInstance == null) {
                connectionInstance = new DBConnection();
            }
        }

        return connectionInstance;
    }

}

