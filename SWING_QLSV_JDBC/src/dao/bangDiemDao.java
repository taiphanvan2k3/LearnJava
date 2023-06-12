package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtils;
import model.bangDiem;

public class bangDiemDao {
	public static boolean insert(bangDiem bd) throws SQLException {
		String sql = "insert into bangDiem(maSinhVien,toan,van,anh)" + " values (?,?,?,?)";
		try (Connection con = JDBCUtils.getInstance(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, bd.getMaSinhVien());
			pst.setFloat(2, bd.getToan());
			pst.setFloat(3, bd.getVan());
			pst.setFloat(4, bd.getAnh());
			return pst.executeUpdate() > 0;
		}
	}

	public static boolean update(bangDiem bd) throws SQLException {
		String sql = "update bangDiem" + " set toan=?,van=?,anh=?" + " where maSinhVien=?";
		try (Connection con = JDBCUtils.getInstance(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setFloat(1, bd.getToan());
			pst.setFloat(2, bd.getVan());
			pst.setFloat(3, bd.getAnh());
			pst.setString(4, bd.getMaSinhVien());
			return pst.executeUpdate() > 0;
		}
	}

	public static boolean deletByStudentID(String maSinhVien) throws SQLException {
		String sql = "delete from bangDiem" + " where maSinhVien=?";
		try (Connection con = JDBCUtils.getInstance(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, maSinhVien);
			return pst.executeUpdate() > 0;
		}
	}

	public static bangDiem createBangDiem(ResultSet rs) throws SQLException {
		bangDiem bd = new bangDiem();
		bd.setMa(rs.getInt("ma"));
		bd.setMaSinhVien(rs.getString("maSinhVien"));
		bd.setToan(rs.getFloat("toan"));
		bd.setAnh(rs.getFloat("anh"));
		bd.setVan(rs.getFloat("van"));
		return bd;
	}
	public static bangDiem findByStudentId(String maSinhVien) throws SQLException {
		String sql = "select * from bangDiem" + " where maSinhVien=?";
		try (Connection con = JDBCUtils.getInstance(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, maSinhVien);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					bangDiem bd=createBangDiem(rs);
					return bd;
				}
			}
		}
		return null;
	}

	public static ArrayList<bangDiem> findAll(String maSinhVien) throws SQLException {
		ArrayList<bangDiem> list = new ArrayList<>();
		String sql = "select * from bangDiem";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					bangDiem bd=createBangDiem(rs);
					list.add(bd);
				}
				return list;
			}
		}
	}
	
	public static ArrayList<bangDiem> findTop(int top) throws SQLException {
		ArrayList<bangDiem> list = new ArrayList<>();
		String sql = "select top "+top+" * from bangDiem"
				+" order by (toan+van+anh)/3 desc";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					bangDiem bd=createBangDiem(rs);
					list.add(bd);
				}
				return list;
			}
		}
	}
	
	public static ArrayList<Object> findStudentAndPoint(String mssv) throws SQLException{
		ArrayList<Object> list = new ArrayList<>();
		String sql ="select sv.maSinhVien,hovaten,toan,van,anh from sinhvien sv"
				+ " left join bangdiem bd on bd.maSinhVien=sv.maSinhVien"
				+ " where sv.maSinhVien=?";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mssv);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					list.add(rs.getString("maSinhVien"));
					list.add(rs.getString("hoVaTen"));
					list.add(rs.getFloat("toan"));
					list.add(rs.getFloat("van"));
					list.add(rs.getFloat("anh"));
				}
				return list;
			}
		}
	}
}
