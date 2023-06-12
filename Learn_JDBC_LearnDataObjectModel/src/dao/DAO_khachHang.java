package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.khachHang;

public class DAO_khachHang implements DAOInterface<khachHang> {

	@Override
	public int insert(khachHang t) {
		// B1: Kết nối với csdl
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "insert into khachhang (id,tenKH,ngaySinh,diaChi)" + " values ('" + t.getId() + "','"
					+ t.getHoTen() + "','" + t.getNgaySinh() + "','" + t.getDiaChi() + "')";
			res = st.executeUpdate(sql);

			// B4:Xử lí kết quả
			System.out.println("Đã thực thi:" + sql);
			System.out.printf("Có %d dòng thay đổi\n", res);

			// B5: Đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(khachHang t) {
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "update khachhang " + "set " + "tenKH='" + t.getHoTen() + "',ngaySinh='" + t.getNgaySinh()
					+ "',diaChi='" + t.getDiaChi() + "' where id='" + t.getId() + "'";

			// Chú ý: "\"" => in ra " hoặc dùn
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
	public int deleteById(khachHang t) {
		int res = 0;
		Connection connection = JDBCUtil.getConnecttion();
		try {
			// B2: Tạo ra đối tượng lớp Statement
			Statement st = connection.createStatement();

			// B3: Thực thi statement
			String sql = "delete from khachhang "+" where id='" + t.getId() + "'";

			// Chú ý: "\"" => in ra " hoặc dùn
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
	public ArrayList<khachHang> selectAll() {
		ArrayList<khachHang> res= new ArrayList<>();
		try {
			Connection c=JDBCUtil.getConnecttion();
			Statement st=c.createStatement();
			String sql="select *from khachHang";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("id");
				String tenKH=rs.getString("tenKH");
				Date ngaySinh=rs.getDate("ngaySinh");
				String diaChi=rs.getString("diaChi");
				khachHang kh= new khachHang(id, tenKH, diaChi, ngaySinh);
				res.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public khachHang selectById(khachHang t) {
		khachHang res= null;
		try {
			Connection c=JDBCUtil.getConnecttion();
			Statement st=c.createStatement();
			String sql="select *from khachHang where id='"+t.getId()+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("id");
				String tenKH=rs.getString("tenKH");
				Date ngaySinh=rs.getDate("ngaySinh");
				String diaChi=rs.getString("diaChi");
				res= new khachHang(id, tenKH, diaChi, ngaySinh);
			}
		} catch (Exception e) {
		}
		return res;
	}

	@Override
	public ArrayList<khachHang> selectByCondition(String condition) {
		ArrayList<khachHang> res= new ArrayList<>();
		try {
			Connection c=JDBCUtil.getConnecttion();
			Statement st=c.createStatement();
			String sql="select *from khachHang where "+condition;
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("id");
				String tenKH=rs.getString("tenKH");
				Date ngaySinh=rs.getDate("ngaySinh");
				String diaChi=rs.getString("diaChi");
				khachHang kh= new khachHang(id, tenKH, diaChi, ngaySinh);
				res.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

}
