package Code;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien> {
	private String mssv, name;
	private int namSinh;
	private double gpa;

	public SinhVien(String mssv, String name, int namSinh, double gpa) {
		this.mssv = mssv;
		this.name = name;
		this.namSinh = namSinh;
		this.gpa = gpa;
	}

	public SinhVien(String mssv) {
		this.mssv = mssv;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	//Xây dựng phương thức này để remove đối tượng theo tiêu chí mssv
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(mssv, other.mssv);
	}

	public String toString() {
		return this.mssv + "," + this.name + "," + this.namSinh + "," + this.gpa;
	}

	@Override
	public int compareTo(SinhVien o) {
		if (this.gpa > o.gpa)
			return -1;
		else if (this.gpa < o.gpa)
			return 1;
		return 0;
	}
}
