
public class SinhVien {
	private String mssv, hoVaTen;
	private NgaySinh dob;
	double gpa;
	Lop tenLop;

	public SinhVien(String mssv, String hoVaTen, NgaySinh dob, double gpa, Lop tenLop) {
		this.mssv = mssv;
		this.hoVaTen = hoVaTen;
		this.dob = dob;
		this.gpa = gpa;
		this.tenLop = tenLop;
	}

	public String getTenKhoa() {
		return this.tenLop.getTenKhoa();
	}

	// Phương thức kiểm tra sinh viên này có đậu hay không
	public boolean ThiDau() {
		return this.gpa >= 5;
	}

	public NgaySinh getNgaySinh() {
		return this.dob;
	}

	// Kiểm tra hai sinh viên có cùng ngày sinh hay không
	public boolean checkSameDob(SinhVien other) {
		return this.dob.equals(other.dob);
	}

}
