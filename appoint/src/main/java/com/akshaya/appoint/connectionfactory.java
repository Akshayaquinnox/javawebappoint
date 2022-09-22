package com.akshaya.appoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionfactory  {
	

	//
	public static final String URL = "akshaya-database.cht7xdgjt3tj.ap-south-1.rds.amazonaws.com";
	public static final String user = "admin";
	public static final String password = "qwertyasdfgh05";
	
	
	public static Connection getCollection() throws  SQLException, ClassNotFoundException  
	{
		System.out.println("Connecting to Database...");
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL, user,password);
		
		if(con.isValid(3))
		{
			System.out.println("Connected to Database.");
		}
		
		return con;
		
}
}
