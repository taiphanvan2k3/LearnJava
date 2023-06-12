package cau2;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	public static Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=Java;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return cnn;
	}

	public static Connection getConnection(String databaseName) {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = String.format(
					"jdbc:sqlserver://localhost:1433;encrypt=true;database=%s;trustServerCertificate=true;",
					databaseName);
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return cnn;
	}

	public static void CloseConnection(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Connection c = JDBCUtils.getConnection("Java");
		if (c != null)
			System.out.println("Success");
	}
}
