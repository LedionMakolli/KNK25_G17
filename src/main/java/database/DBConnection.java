package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;
    private static final String DBURL = "jdbc:postgresql://localhost:5432/knk_ushtrimet";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        if (connection == null){
            try{
                 connection = DriverManager.getConnection(DBURL,USER,PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
