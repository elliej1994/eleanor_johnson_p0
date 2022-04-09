package dev.johnson.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection(){

            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://johnson-db.cbn3pfkjnp4z.us-east-1.rds.amazonaws.com/librarydb?user=postgres&password=!pinkkeyboardwithRBG?");
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

//johnson-db.cbn3pfkjnp4z.us-east-1.rds.amazonaws.com