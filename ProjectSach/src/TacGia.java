import java.util.Scanner;
public class TacGia {
	private String tenTacGia;
	private Date ngaySinh;
	private Scanner sc;
	public TacGia() {
		ngaySinh=new Date();
		sc=new Scanner(System.in);
	}
	public TacGia(String tenTacGia, Date ngaySinh) {
		this.tenTacGia = tenTacGia;
		this.ngaySinh = ngaySinh;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void nhap_tt_tac_gia() {
		System.out.println("Nhập họ tên:");
		tenTacGia=sc.nextLine();
		ngaySinh.nhap_tt();
	}
}
