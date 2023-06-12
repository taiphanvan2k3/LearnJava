package File_p7.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSv {
	private ArrayList<SinhVien> dssv;

	public DanhSachSv() {
		this.dssv = new ArrayList<SinhVien>();
	}

	public ArrayList<SinhVien> getDssv() {
		return dssv;
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

	public boolean timKiemTheoMSSV(SinhVien sv) {
		return this.dssv.contains(sv);
	}

	// Xoá sinh viên theo mã số sinh viên cách 1 (1 đối tượng lớp sinh viên)
	public void xoaSinhVienTheoMSSV(SinhVien sv) {
		if (this.timKiemTheoMSSV(sv) == false)
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

	public void sapXepGiamDanGpa1() {
		// Do có compareTo rồi nên sort thì nó sẽ sx dựa theo phương thức này
		Collections.sort(this.dssv);
	}

	// Xây dựng comparator để so sánh
	public void sapXepGiamDanGpa2() {
		Collections.sort(this.dssv, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getGpa() > o2.getGpa())
					return -1;
				else if (o1.getGpa() < o2.getGpa())
					return 1;
				return 0;
			}

		});
	}

	// Phương thức ghi toàn bộ danh sách sinh viên xuống file
	public void writeIntoFile(File f) {
		try {
			OutputStream os = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeInt(this.dssv.size());
			for (SinhVien sinhVien : dssv) {
				oos.writeObject(sinhVien);
			}
			os.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Phương thức đọc toàn bộ danh sách sinh viên từ file
	public void readFromFile(File f) throws ClassNotFoundException, IOException {
		ObjectInputStream ois = null;
		InputStream is = null;
		try {
			is = new FileInputStream(f);
			ois = new ObjectInputStream(is);
			int n = ois.readInt();
//			while (true) {
//				Object obj = ois.readObject();
//				if (obj == null)
//					break;
//				this.dssv.add((SinhVien)obj);
//			}
			/**
			 * Nếu dùng vòng lặp while trên thì bị quăng ngoại lệ do EOF
			 */
			for (int i = 0; i < n; i++) {
				SinhVien sv = (SinhVien) ois.readObject();
				this.dssv.add(sv);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				ois.close();
			if (is != null)
				is.close();
		}
	}
}
