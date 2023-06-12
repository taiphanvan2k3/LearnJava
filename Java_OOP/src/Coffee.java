
public class Coffee {
	private double donGia, khoiLuong;
	private String ten;

	public Coffee(String ten, double donGia, double khoiLuong) {
		this.ten = ten;
		this.donGia = donGia;
		this.khoiLuong = khoiLuong;
	}

	public String getName() {
		return this.ten;
	}

	public double tongTien() {
		return this.donGia * this.khoiLuong;
	}

	boolean checkLarger(double kl) {
		return this.khoiLuong > kl;
	}

	public double Sale(double x) {
		double price = this.tongTien();
		if (price > 500000)
			return price *x/100;
		return 0;
	}
	public double thanhTien(double x) {
		return this.tongTien()-this.Sale(x);
	}
}
