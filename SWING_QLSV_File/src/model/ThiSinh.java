package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable{
	private int mssv;
	private String ten, queQuan;
	private boolean gioiTinh;
	// nam=true,nữ=false
	private float mon1, mon2, mon3;
	private Date dob;

	public ThiSinh() {
	}

	public ThiSinh(int mssv, String ten, String queQuan, boolean gioiTinh, float mon1, float mon2, float mon3,
			Date dob) {
		this.mssv = mssv;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mon3 = mon3;
		this.dob = dob;
		this.queQuan = queQuan;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getQueQuan() {
		return this.queQuan;
	}

	public boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getMon1() {
		return mon1;
	}

	public void setMon1(float mon1) {
		this.mon1 = mon1;
	}

	public float getMon2() {
		return mon2;
	}

	public void setMon2(float mon2) {
		this.mon2 = mon2;
	}

	public float getMon3() {
		return mon3;
	}

	public void setMon3(float mon3) {
		this.mon3 = mon3;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		String sex = "";
		if (this.gioiTinh)
			sex = "Nam";
		else
			sex = "Nữ";
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		return "[mssv:" + mssv + ", ten:" + ten + ", queQuan:" + queQuan + ", gioiTinh:" + sex + ", mon1:" + mon1
				+ ", mon2:" + mon2 + ", mon3:" + mon3 + ", dob:" + df.format(dob) + ":";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mssv);
	}

	@Override
	// Dựa theo mã sinh viên để so sánh
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return mssv == other.mssv;
	}

}
