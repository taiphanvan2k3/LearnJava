
public class Plane extends Transport{
	private String loaiNhienLieu;

	public Plane(String tenPhuongTien, HangSanXuat hangSX, String loaiNhienLieu) {
		super(tenPhuongTien, hangSX);
		this.loaiNhienLieu = loaiNhienLieu;
	}
	public void catCanh() {
		System.out.println("Ready to depart");
	}
	public void haCanh() {
		System.out.println("10 minutes ....");
	}
	@Override
	public String loaiNhienLieu() {
		return this.loaiNhienLieu;
		
	}
	@Override
	public double layVanToc() {
		return 300;
	}
}
