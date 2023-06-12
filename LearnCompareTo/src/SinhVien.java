
public class SinhVien implements Comparable<SinhVien> {
	private int masv;
	private String name, lop;
	private double gpa;

	public SinhVien(int masv, String name, String lop, double gpa) {
		this.masv = masv;
		this.name = name.trim();
		this.lop = lop;
		this.gpa = gpa;
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getFirstName() {
		int vt = this.name.lastIndexOf(' ');
		return this.name.substring(vt + 1);
	}

	//So sánh compareTo dựa theo 
	public int compareTo(SinhVien sv) {
		String firstName1 = this.getFirstName();
		String firstName2 = sv.getFirstName();
		return firstName1.compareTo(firstName2);
	}
	@Override
	public String toString() {
		return masv+"."+name+","+lop+","+gpa;
	}
}
