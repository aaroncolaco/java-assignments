package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Override and implement all the methods of DBConnectionUtil Interface in this class 
public class DatabaseConnectionManager implements DBConnectionUtil {
	
	Connection connection = null;

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb", "root", "root");

        return connection;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		connection.close();
	}		
		
}
