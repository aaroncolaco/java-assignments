package com.util;

//Override and implement all the methods of DBConnectionUtil here to create and close db connection 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager implements DBConnectionUtil {
   
    Connection connection = null;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb", "root", "root");

        return connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb", "root", "root");
        
        connection.close();
    }

}
