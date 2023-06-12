package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		Connection c=JDBCUtil.getConnection();
		if(c!=null)
			System.out.println("Thanh cong");
//		try {
//			
//			//DB này đã bị xoá rồi
//			PreparedStatement st= c.prepareStatement("select *from student where id > ?");
//			st.setInt(1, 2);
//			ResultSet rs=st.executeQuery();
//			while(rs.next()) {
//				int id=rs.getInt("id");
//				String ho=rs.getString("ho");
//				String ten=rs.getString("ten");
//				String sdt=rs.getString("sdt");
//				System.out.println(id+" "+ho+" "+ten+" "+sdt);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		JDBCUtil.closeConnection(c);
	}
}
