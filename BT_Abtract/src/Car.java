
public class Car extends Transport {
	private String loaiNhienLieu;

	public Car(String tenPhuongTien, HangSanXuat hangSX, String loaiNhienLieu) {
		super(tenPhuongTien, hangSX);
		this.loaiNhienLieu = loaiNhienLieu;
	}
	@Override
	public String loaiNhienLieu() {
		return this.loaiNhienLieu;
		
	}
	@Override
	public double layVanToc() {
		return 50;
	}

}
