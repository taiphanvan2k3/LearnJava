package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class testConnection {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			String connectionUrl = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;encrypt=true;database=test;trustServerCertificate=true;"; 
			String username="demo";
			String password="taiphan2403";
			Connection con = DriverManager.getConnection(connectionUrl,username,password);
			System.out.println("Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
