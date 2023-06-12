package model;

//1 sinhvien - 1 bangdiem
public class bangDiem {
	private int ma;
	private String maSinhVien;
	private float toan, van, anh;

	public bangDiem() {
		super();
	}

	public bangDiem(int ma, String maSinhVien, float toan, float van, float anh) {
		super();
		this.ma = ma;
		this.maSinhVien = maSinhVien;
		this.toan = toan;
		this.van = van;
		this.anh = anh;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public float getToan() {
		return toan;
	}

	public void setToan(float toan) {
		this.toan = toan;
	}

	public float getVan() {
		return van;
	}

	public void setVan(float van) {
		this.van = van;
	}

	public float getAnh() {
		return anh;
	}

	public void setAnh(float anh) {
		this.anh = anh;
	}

}
