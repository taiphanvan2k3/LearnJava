package Cau2;

import java.sql.Date;

public class HocVien {
	private String MaSV;
	private String HoTen;
	private Date NgaySinh;
	private String GioiTinh;
	private double Diem;

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public double getDiem() {
		return Diem;
	}

	public void setDiem(double diem) {
		Diem = diem;
	}

	public HocVien() {
	}

	public HocVien(String str) {
		this.MaSV = str.substring(0, 10);
		this.HoTen = str.substring(10, 59).trim();
		String date = str.substring(59, 69);
		this.GioiTinh = str.substring(69, 72).trim();
		String diemThi = str.substring(72);
		System.out.println(MaSV + "," + HoTen + "," + date + "," + GioiTinh + "," + diemThi);
	}
}
