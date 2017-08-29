package com.jey.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PendingDBOracleConnection {
    private static Connection connection;
    
    private PendingDBOracleConnection() 
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            String url = "jdbc:oracle:thin:@pendingcustomers.c9xv5z6yf0yo.us-west-2.rds.amazonaws.com:1521:ORCL";
            String username = "training";
            String password = "p4ssw0rd";
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getOracleConnection()
    {
        if (connection == null)
        {
            new PendingDBOracleConnection();
        }
        return connection;
    }
}