package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSv {
	private ArrayList<SinhVien> dssv;

	public DanhSachSv() {
		this.dssv = new ArrayList<SinhVien>();
	}

	public DanhSachSv(ArrayList<SinhVien> dssv) {
		this.dssv = dssv;
	}

	// Thêm 1 sinh viên vào cuối
	public void themSinhVien(SinhVien sv) {
		this.dssv.add(sv);
	}

	public void inDanhSach() {
		for (SinhVien sv : dssv)
			System.out.println(sv);

	}

	public boolean kiemTraDachSachrong() {
		return this.dssv.isEmpty();
	}

	public int soLuongSinhVien() {
		return this.dssv.size();
	}

	public void xoaTatCaSinhVien() {
		this.dssv.clear();
	}

	public boolean timKiemTheoMSSV(String mssv) {
		for (SinhVien sv : dssv)
			if (sv.getMssv().compareToIgnoreCase(mssv) == 0)
				return true;
		return false;
	}

	public boolean timKiemTheoMSSV(SinhVien sv) {
		return this.dssv.contains(sv);
	}

	//Xoá sinh viên theo mã số sinh viên cách 1 ( truyền vào xâu mssv)
	public void xoaSinhVienTheoMSSV(String mssv) {
		int id = -1;
		for (int i = 0; i < dssv.size(); i++) {
			if (dssv.get(i).getMssv().compareTo(mssv) == 0) {
				id=i;
				break;
			}
		}
		if (id == -1)
			System.out.println("Không tồn tại mã số sinh viên mà bạn muốn xoá ");
		else {
			dssv.remove(id);
			System.out.println("Đã xoá thành công !");
		}
	}
	//Xoá sinh viên theo mã số sinh viên cách 1 (1 đối tượng lớp sinh viên)
	public void xoaSinhVienTheoMSSV(SinhVien sv) {
		if(this.timKiemTheoMSSV(sv)==false)
			System.out.println("Không tìm thấy sinh viên có mã số cần tìm.");
		else {
			this.dssv.remove(sv);
			System.out.println("Đã xoá thành công!");
		}
	}
	public void timKiemTheoTen(String ten) {
		boolean check = false;
		ten = ten.toLowerCase();
		for (SinhVien sv : dssv) {
			String hvt = sv.getName().toLowerCase();
			if (hvt.indexOf(ten) != -1) {
				System.out.println(sv);
				check = true;
			}
		}
		if (!check)
			System.out.println("Không tìm thấy tên sinh viên bạn muốn tìm");
	}
	//Nên dùng Comparator khi phương thức compareTo thực hiện cho một thao
	//tác khác rồi
	public void inDanhSachGiamDanTheoGPA() {
		Collections.sort(this.dssv, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getGpa() < o2.getGpa())
					return 1;
				else if (o1.getGpa() > o2.getGpa())
					return -1;
				return 0;
			}

		});
	}
	//Không cần xây dựng thêm comparator mà dựa vào compareTo
	public void inDanhSachGiamDanTheoGPA2() {
		Collections.sort(this.dssv);
	}
}
