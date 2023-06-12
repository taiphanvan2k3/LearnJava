package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnecttion() {
		Connection c = null;
		try {
			// Không nhất thiết phải register hay Class.forname(..)
			String url = "jdbc:mysql://localhost:3306/nhasach";
			String usename = "root";
			String password = "";

			// Tạo kết nối
			c = DriverManager.getConnection(url, usename, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void displayInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDriverName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
