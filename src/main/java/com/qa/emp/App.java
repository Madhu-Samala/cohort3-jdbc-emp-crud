package com.qa.emp;

import java.sql.Connection;

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
        Connection dbConnection = repository.getDbConnection();
        
    }
}
