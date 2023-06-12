
public abstract class Transport {
	protected String tenPhuongTien;
	protected HangSanXuat hangSX;

	public Transport(String tenPhuongTien, HangSanXuat hangSX) {
		this.tenPhuongTien = tenPhuongTien;
		this.hangSX = hangSX;
	}

	public String getTenPhuongTien() {
		return tenPhuongTien;
	}

	public void setLoaiPhuongTien(String loaiPhuongTien) {
		this.tenPhuongTien = loaiPhuongTien;
	}

	public void batDau() {
		System.out.println("Start");
	}

	public void tangToc() {
		System.out.println("speed up");
	}

	public void dungLai() {
		System.out.println("Stop");
	}

	public String layTenHangSX() {
		return this.hangSX.getTenHangSx();
	}
	//Vì không biết từng loại phương tiện sẽ dùng loại nhiên liệu gì
	//hay vận tốc bao nhiêu nên ta dùng abstact method để lớp con
	//đi định nghĩa chúng
	public abstract String loaiNhienLieu();

	public abstract double layVanToc();

	@Override
	public String toString() {
		return this.tenPhuongTien + "," + this.layTenHangSX()+","+this.loaiNhienLieu()+"\t Max speed:" + this.layVanToc() + " km/h";
	}
}
