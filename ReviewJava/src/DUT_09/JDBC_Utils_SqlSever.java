package DUT_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Utils_SqlSever {
	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=QLDA;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			c = DriverManager.getConnection(url, username, pass);
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

	public static void main(String[] args) {
		Connection c = getConnection();
		if (c != null)
			System.out.println("Thanh cong");
	}
}
