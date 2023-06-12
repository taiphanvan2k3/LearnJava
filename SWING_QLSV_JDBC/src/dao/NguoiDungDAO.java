package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBCUtils;
import model.NguoiDung;

public class NguoiDungDAO {
	public static NguoiDung checkLogin(String tk, String mk) throws SQLException {
		String sql = "select *from nguoiDung where tenDangNhap=? " + "and matKhau=?";
		try (Connection con = JDBCUtils.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, tk);
			pst.setString(2, mk);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					NguoiDung res = new NguoiDung();
					res.setTenDangNhap(rs.getString("tenDangNhap"));
					res.setVaiTro(rs.getString("role"));
					return res;
				}
			}
		}
		return null;
	}
	
	
}
