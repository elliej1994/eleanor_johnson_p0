package dev.johnson.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection(){

            try {
                Connection conn = DriverManager.getConnection(System.getenv("LIBRARYDB"));
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
    }


    //"jdbc:postgresql://johnson-db.cwrqnnecy1to.us-east-2.rds.amazonaws.com/librarydb?user=postgres&password=!pinkkeyboardwithRBG?"