
public class film {
	private String tenFilm;
	private int namSX;
	private producer hangSX;
	private double price;
	private Date ngayChieu;

	public film(String tenFilm, int namSX, producer hangSX, double price, Date ngayChieu) {
		super();
		this.tenFilm = tenFilm;
		this.namSX = namSX;
		this.hangSX = hangSX;
		this.price = price;
		this.ngayChieu = ngayChieu;
	}

	public double getPrice() {
		return price;
	}

	public boolean Check(film other) {
		return this.price < other.price;
	}

	public String tenHangSX() {
		return this.hangSX.getName();
	}

	public double giamGia(double x) {
		return price * x / 100;
	}

	public double thanhTien(double x) {
		return this.price - this.giamGia(x);
	}
	public Date getNgayChieu() {
		return this.ngayChieu;
	}
}
