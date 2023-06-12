package model;

public class sach {
	private String id, tenSach;
	private int namXB, price;

	public sach() {
	}

	public sach(String id, String tenSach, int price, int namXB) {
		super();
		this.id = id;
		this.namXB = namXB;
		this.price = price;
		this.tenSach = tenSach;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "sach [id=" + id + ", tenSach=" + tenSach + ", namXB=" + namXB + ", price=" + price + "]";
	}
}
