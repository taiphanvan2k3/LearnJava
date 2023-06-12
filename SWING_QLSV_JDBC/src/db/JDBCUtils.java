package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static Connection connection;

	public static Connection getInstance() {
		if (connection == null)
			connection = getConnection();
		return connection;
	}

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=QLSV;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			c = DriverManager.getConnection(url, username, pass);
			System.out.println("Thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null)
			try {
				c.close();
				System.out.println("Đã đóng kết nối");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
