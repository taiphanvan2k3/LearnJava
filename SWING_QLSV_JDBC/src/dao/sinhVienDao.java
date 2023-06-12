package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import db.JDBCUtils;
import model.sinhvien;

public class sinhVienDao {
	public static boolean insert(sinhvien sv) throws SQLException {
		String sql = "insert into sinhvien(maSinhVien,hoVaTen,email,sdt,gioiTinh,diaChi,Hinh)"
				+ " values (?,?,?,?,?,?,?)";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, sv.getMaSinhVien());
			pst.setString(2, sv.getHoVaTen());
			pst.setString(3, sv.getEmail());
			pst.setString(4, sv.getSdt());
			pst.setInt(5, sv.getGioiTinh());
			pst.setString(6, sv.getDiaChi());
			if (sv.getHinh() != null) {
				Blob hinh = new SerialBlob(sv.getHinh());
				pst.setBlob(7, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(7, hinh);
			}
			return pst.executeUpdate() > 0;
		}
	}

	public static boolean update(sinhvien sv) throws SQLException {
		String sql = "update sinhvien" + " set hoVaTen=?,email=?,sdt=?,gioiTinh=?,diaChi=?,Hinh=?"
				+ " where maSinhVien=?";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, sv.getHoVaTen());
			pst.setString(2, sv.getEmail());
			pst.setString(3, sv.getSdt());
			pst.setInt(4, sv.getGioiTinh());
			pst.setString(5, sv.getDiaChi());
			if (sv.getHinh() != null) {
				Blob hinh = new SerialBlob(sv.getHinh());
				pst.setBlob(6, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(6, hinh);
			}
			pst.setString(7, sv.getMaSinhVien());
			return pst.executeUpdate() > 0;
		}
	}

	public static boolean delete(String mssv) throws SQLException {
		String sql = "delete from sinhvien" + " where maSinhVien=?";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mssv);
			return pst.executeUpdate() > 0;
		}
	}

	private static void setDataForStudent(sinhvien res, ResultSet rs) throws SQLException {
		res.setMaSinhVien(rs.getString("maSinhVien"));
		res.setEmail(rs.getString("Email"));
		res.setSdt(rs.getString("sdt"));
		res.setHoVaTen(rs.getString("hoVaTen"));
		res.setDiaChi(rs.getString("DiaChi"));
		res.setGioiTinh(rs.getInt("gioiTinh"));
		Blob blob = rs.getBlob("Hinh");
		if (blob == null)
			res.setHinh(null);
		else
			// Chú ý là getBytes từ 1 chứ ko phải là 0
			// vì:pos the ordinal position of the first byte in the BLOB value to be
			// extracted; the first byte is at position 1
			res.setHinh(blob.getBytes(1, (int) blob.length()));
	}

	public static sinhvien findById(String mssv) throws SQLException {
		String sql = "select * from sinhvien" + " where maSinhVien=?";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mssv);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					sinhvien res = new sinhvien();
					setDataForStudent(res, rs);
					return res;
				}
			}
		}
		return null;
	}

	public static ArrayList<sinhvien> findAllStudent() throws SQLException {
		ArrayList<sinhvien> res = new ArrayList<>();
		String sql = "select * from sinhvien";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					sinhvien sv = new sinhvien();
					setDataForStudent(sv, rs);
					res.add(sv);
				}
				return res;
			}
		}
	}
}
