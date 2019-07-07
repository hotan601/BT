package vn.mista.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/students";
	public static final String USER = "root";
	public static final String PASS = "Weak";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch(Exception ex) {
			throw new RuntimeException(" error connectiing to your DB",ex);
		}
	}
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.getConnection();
	}
}
