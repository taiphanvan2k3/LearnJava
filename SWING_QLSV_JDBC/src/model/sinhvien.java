package model;

public class sinhvien {
	private String maSinhVien, hoVaTen, email, sdt, diaChi;
	private int gioiTinh;
	private byte[] Hinh;

	public sinhvien() {
		super();
	}

	public sinhvien(String maSinhVien, String hoVaTen, String email, String sdt, String diaChi, int gioiTinh,
			byte[] hinh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		Hinh = hinh;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public byte[] getHinh() {
		return Hinh;
	}

	public void setHinh(byte[] hinh) {
		Hinh = hinh;
	}

}
