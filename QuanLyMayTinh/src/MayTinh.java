
public class MayTinh {
	private HangSx producer;
	private NgaySanXuat ngaysx;
	double price;
	private int warranty_month;

	public MayTinh(HangSx producer, NgaySanXuat ngaysx, double price, int warranty_month) {
		this.producer = producer;
		this.ngaysx = ngaysx;
		this.price = price;
		this.warranty_month = warranty_month;
	}

	public boolean checkLowerPrice(MayTinh other) {
		return this.price < other.price;
	}

	public String tenQuocGiaSx() {
		return this.producer.getInfoCountry().getTenQuocGia();
	}
}
