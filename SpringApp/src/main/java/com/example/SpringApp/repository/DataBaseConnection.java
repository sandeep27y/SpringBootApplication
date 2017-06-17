package com.example.SpringApp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection con;
	
	public static Connection getConnection(){		
		if(con==null){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","12345");
			System.out.println("Connected sucessfully");
			
		} 
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return con;
	}
}
