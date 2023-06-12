import java.util.Scanner;

public class book {
	//Phải khai báo class Scanner ở mỗi file
	private Scanner sc;
	private String tenSach;
	private double price;
	private int namXuatBan;
	private TacGia tacGia;

	public book() {
		tacGia = new TacGia();
		sc = new Scanner(System.in);
	}

	public book(String tenSach, double price, int namXuatBan, TacGia tacGia) {
		this.tenSach = tenSach;
		this.price = price;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public TacGia getTacgia() {
		return tacGia;
	}

	public void setTacgia(TacGia tacgia) {
		this.tacGia = tacgia;
	}

	boolean check(book obj) {
		return this.namXuatBan == obj.namXuatBan;
	}

	public double thanhTien(double x) {
		return price * (1 - x / 100);
	}

	public void nhap_tt() {
		System.out.print("Tên sách:");
		tenSach = sc.nextLine();
		System.out.print("Giá:");
		price = sc.nextDouble();
		System.out.print("Năm xuất bản:");
		namXuatBan = sc.nextInt();
		// Lúc qua class tacGia thì đã new lại Scanner
		// rồi nên không sợ bị trôi String
		tacGia.nhap_tt_tac_gia();
	}

	public void display() {
		System.out.println(tenSach + "\t" + namXuatBan + "\t" + 
		tacGia.getTenTacGia() + "\t" + tacGia.getNgaySinh() + "\t" + price);
	}
}
