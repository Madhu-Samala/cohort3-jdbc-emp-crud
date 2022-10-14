package com.qa.emp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeRepository {
	
	public Connection getDbConnection() {
		Connection connection = null;
			
			try {
				/*
				 * 1. Register the Driver
				 * com.mysql.cj.jdbc.Driver
				 */
				Class.forName("com.mysql.cj.jdbc.Driver");
				/*
				 * DriverManager
				 */
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
					if(connection != null) {
						System.out.println("Connected to database success:: empdb"  );
					}
				
				} catch (SQLException e) {
					System.out.println("Invalid database credentials");
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL Connector jar file not found in the class path");
				e.printStackTrace();
			}
			
			return connection;
		
	}

}
