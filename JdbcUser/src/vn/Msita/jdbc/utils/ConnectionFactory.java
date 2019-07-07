package vn.Msita.jdbc.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL="jdbc:mysql://localhost:3306/user";
	public static final String USER="root";
	public static final String PASS="Weak";
	
	public static Connection getConnection()  {
	    
	    try {
	       return  DriverManager.getConnection(URL, USER, PASS);
	    } catch (Exception ex) {
	    	throw new RuntimeException(" error connecting to the DB",ex);
	    }
	   
	}
	
	public static void main(String[] args) throws SQLException {
		//ConnectionFactory.getConnection();
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.getConnection();
	}
}
//Connection la doi tuong de chung ta connect vs DB
