package File_p7.Main;
import java.io.Serializable;
import java.util.Objects;
//implements Comparable để sort
//implements Serializable để ghi đối tượng xuống file
public class SinhVien implements Comparable<SinhVien>,Serializable {
	private String mssv, name;
	private int namSinh;
	private double gpa;

	public SinhVien(String mssv) {
		this.mssv = mssv;
	}

	public SinhVien(String mssv, String name, int namSinh, double gpa) {
		this.mssv = mssv;
		this.name = name;
		this.namSinh = namSinh;
		this.gpa = gpa;
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
	public int compareTo(SinhVien o) {
		if (this.gpa < o.gpa)
			return 1;
		else if (this.gpa > o.gpa)
			return -1;
		return 0;
	}

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

	@Override
	public String toString() {
		return this.mssv + "," + this.name + "," + this.namSinh + "," + this.gpa;
	}

}
