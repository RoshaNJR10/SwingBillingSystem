package com.nist.billingsystem.bill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private final static String DATABASE_NAME="billingsystem";
	private final static String USERNAME="root";
	private final static String PASSWORD="";
	private final static String DRIVER_NAME="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost/";
	
	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL+DATABASE_NAME,USERNAME,PASSWORD);
	}
}
