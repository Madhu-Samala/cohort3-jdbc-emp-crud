package com.qa.emp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qa.emp.repository.EmployeeRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeRepository repository = new EmployeeRepository();
        Connection con = repository.getDbConnection();
        
        //SQL Queries
        
        //Statement
        //executeUpdate(String query)
        //executeQuery(String query) // SELECT
        try {
			Statement stmt = con.createStatement();
			String sqlQuery = "create table if not exists emp_details(id INT,name VARCHAR(45),salary DOUBLE)";
			int rows = stmt.executeUpdate(sqlQuery);
			System.out.println(rows);
			
			//Input
			Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id:");
		int id = scanner.nextInt();
		System.out.println("Enter Name:");
		String name = scanner.next();
		System.out.println("Enter Salary:");
		double salary = scanner.nextDouble();
		
			
			String insertQuery = "insert into emp_details values("+id+",'"+name+"',"+salary+")";
			
			int insertedRows = stmt.executeUpdate(insertQuery);
			System.out.println(insertedRows);
			System.out.println("Enter id");
			id = scanner.nextInt();
			System.out.println("Enter the updated salary:");
			double updateSalary = scanner.nextDouble();
			
			String updatQueyr = "update emp_details set salary="+updateSalary+" where id= "+id+"";
			
			rows = stmt.executeUpdate(updatQueyr);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
