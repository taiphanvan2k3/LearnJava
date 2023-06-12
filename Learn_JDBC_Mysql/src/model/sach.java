package model;

public class sach {
	private int namXB, price;
	private String maSach, tenSach;

	public sach() {
	}

	public sach(int namXB, int price, String maSach, String tenSach) {
		super();
		this.namXB = namXB;
		this.price = price;
		this.maSach = maSach;
		this.tenSach = tenSach;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

}
