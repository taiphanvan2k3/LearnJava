import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	public Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// demodb là tên DB
			// String url = "jdbc:mysql://localhost:3306/demodb";
			String url = "jdbc:mysql://localhost/demodb";
			String usename = "root";
			String password = "";
			c = DriverManager.getConnection(url, usename, password);
		} catch (Exception e) {
		}
		return c;
	}

	public static Connection getConnection(String ip, String databaseName, String username, String password) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// demodb là tên DB
			String url = "jdbc:mysql://" + ip + "/" + databaseName;
			c = DriverManager.getConnection(url, username, "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}

	public void CloseConnection(Connection c) {
		try {
			c.close();
			System.out.println("Closed");
		} catch (Exception e) {
			System.out.println("Failed to close");
		}
	}

	public static void main(String[] args) {
		JDBCUtils t = new JDBCUtils();
		Connection c = JDBCUtils.getConnection("localhost", "demoDB", "root", "");
		if (c != null) {
			try {
				// java.sql
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("select *from sinhvien");
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++)
					System.out.println(rsmd.getColumnName(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		t.CloseConnection(c);
	}
}
