package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO_khachHang;
import dao.DAO_sach;
import database.JDBCUtil;
import model.khachHang;
import model.sach;

public class test {

	public static void testDAO_sach() {
		DAO_sach t = new DAO_sach();

		// Chức năng insert
		for (int i = 0; i <= 1000; i++) {
			sach s = new sach("LT" + i, "Lập trình" + i, 2000, 20000);
			t.insert(s);
		}

		// Chức năng update
		sach s = new sach("LT1", "Lập trình JAVA", 2005, 100000);
		t.update(s);

		// Chức năng delete
		t.deleteById(s);

		// Chức năng select *
		ArrayList<sach> arr = t.selectAll();
		for (sach sach : arr) {
			System.out.println(sach);
		}

		// Chức năng select *from sach id=...
		sach pattern = new sach();
		pattern.setId("3");
		sach res = t.selectById(pattern);
		System.out.println(res);

		// Chức năng select by condition
		//do là kiểu dữ liệu số nên chỉ cần price>20000 là được
		String condition = "price >20000";
		ArrayList<sach> res1 = t.selectByCondition(condition);
		for (sach s1 : res1) {
			System.out.println(s1);
		}
	}

	public static void testDAO_khachHang() {
		DAO_khachHang dao = new DAO_khachHang();
		int year = 2003, month = 1, day = 1;
		Date d = new Date(year - 1900, month - 1, day);
		khachHang kh = new khachHang("KH_new", "BS Hiệu", "Điện Minh", d);
		dao.insert(kh);
		dao.update(kh);
		khachHang kh_del = new khachHang("2", "BS Hiệu", "Điện Minh", d);
		dao.deleteById(kh_del);

		ArrayList<khachHang> res = dao.selectAll();
		for (khachHang KH : res) {
			System.out.println(KH);
		}

		khachHang pattern = new khachHang();
		pattern.setId("kh_2");
		System.out.println(dao.selectById(pattern));

		//do là kiểu dữ liệu xâu nên phần cần có " " mới được
		res = dao.selectByCondition("TenKH=\"BS Hiệu\"");
		for (khachHang KH : res) {
			System.out.println(KH);
		}
	}

	public static void testPrepareStatement() {
		Connection con=JDBCUtil.getConnecttion();
		String sql="select *from dangnhap where id_user =?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,2);
			ResultSet res=pst.executeQuery();
			while(res.next()) {
				System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		testDAO_khachHang();
		// testDAO_sach();
		testPrepareStatement();
	}
}
