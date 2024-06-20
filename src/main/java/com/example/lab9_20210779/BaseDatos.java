package com.example.lab9_20210779;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDatos {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.load(BaseDatos.class.getClassLoader().getResourceAsStream("db.properties"));
                String url = props.getProperty("jdbc:mysql://localhost:3306/lab9_db_h691");
                String user = props.getProperty("root");
                String password = props.getProperty("root");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
                throw new SQLException("No se puede conectar a la base de datos");
            }
        }
        return connection;
    }
}
