package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.sach;

public class DAO_sach implements DAOInterface<sach> {

	@Override
	public int insert(sach t) {
		// B1: Kết nối với csdl
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "insert into sach" + " values (" + "\"" + t.getId() + "\"" + "," + "\"" + t.getTenSach() + "\""
					+ "," + t.getPrice() + "," + t.getNamXB() + ")";

			// Chú ý: "\"" => in ra "
			res += st.executeUpdate(sql);
			// B4:Xử lí kết quả
			System.out.println("Đã thực thi:" + sql);

			// B5: Đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Có %d dòng thay đổi\n", res);
		return res;
	}

	@Override
	public int update(sach t) {
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "update sach " + "set " + "tenSach='" + t.getTenSach() + "',price=" + t.getPrice()
					+ ",namXuatBan=" + t.getNamXB() + " where id='" + t.getId() + "'";

			// Chú ý: "\"" => in ra "
			res += st.executeUpdate(sql);
			// B4:Xử lí kết quả
			System.out.println("Đã thực thi:" + sql);

			// B5: Đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Có %d dòng thay đổi\n", res);
		return res;
	}

	@Override
	public int deleteById(sach t) {
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "delete from sach " + " where id='" + t.getId() + "'";

			// Chú ý: "\"" => in ra "
			res += st.executeUpdate(sql);
			// B4:Xử lí kết quả
			System.out.println("Đã thực thi:" + sql);

			// B5: Đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Có %d dòng thay đổi\n", res);
		return res;
	}

	@Override
	public ArrayList<sach> selectAll() {
		ArrayList<sach> res = new ArrayList<>();
		try {
			// B1:
			Connection connection = JDBCUtil.getConnecttion();
			// B2:
			Statement st = connection.createStatement();
			// B3:Tạo câu lệnh truy vấn
			String sql = "select *from sach";
			ResultSet resultSet = st.executeQuery(sql);
			// B4:
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String tenSach = resultSet.getString("tenSach");
				int price = resultSet.getInt("price");
				int namXB = resultSet.getInt("namXuatBan");
				sach s = new sach(id, tenSach, price, namXB);
				res.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public sach selectById(sach t) {
		sach res = null;
		try {
			Connection c = JDBCUtil.getConnecttion();
			Statement st = c.createStatement();
			String sql = "select *from sach where id='" + t.getId() + "'";
			ResultSet rs = st.executeQuery(sql);

			// Tuy trả về 1 bản ghi nhưng cũng phần cần rs.next()
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				int price = rs.getInt("price");
				int namXB = rs.getInt("namXuatBan");
				res = new sach(id, tenSach, price, namXB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ArrayList<sach> selectByCondition(String condition) {

		ArrayList<sach> res = new ArrayList<>();
		try {
			Connection c = JDBCUtil.getConnecttion();
			Statement st = c.createStatement();
			String sql = "select *from sach where " + condition;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				int price = rs.getInt("price");
				int namXB = rs.getInt("namXuatBan");
				sach s = new sach(id, tenSach, price, namXB);
				res.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}