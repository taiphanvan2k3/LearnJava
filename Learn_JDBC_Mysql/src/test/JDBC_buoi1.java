package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.testMySQL;

public class JDBC_buoi1 {
	public static void main(String[] args) {
		// B1: Kết nối với CSDL
		// Trước khi chạy phải start MySQL trên Xampp đã
		testMySQL t = new testMySQL();
		Connection connection = t.getConnecttion();

		try {
			// B2:Tạo ra đối tượng statement
			Statement st = connection.createStatement();
			String sql1 = "select count(*) as cnt from sinhvien";
			ResultSet rs = st.executeQuery(sql1);
			while (rs.next()) {
				// int cnt=rs.getInt("cnt"); cũng được
				int cnt = rs.getInt(1);
				System.out.println(cnt);
			}

			// B4: Xử lí kết quả
			// ....
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Bước 5:Ngắt kết nối
		t.closeConnection(connection);
	}
}
