import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RutTham {
	Set<String> hs = new HashSet<String>();

	public void themMaSoDuThuong(String val) {
		this.hs.add(val);
	}

	public void xoaPhieu(String val) {
		this.hs.remove(val);
	}

	public boolean kiemTraPhieuTonTai(String val) {
		return this.hs.contains(val);
	}

	public void xoaTatCaCacPhieu() {
		this.hs.clear();
	}

	public int laySoLuongPhieu() {
		return this.hs.size();
	}

	public String rutTham() {
		String kq = "";
		Random rd = new Random();
		int vt = rd.nextInt(this.hs.size());
		// String[] o=this.hs.toArray(new String[0]);
		Object[] o = this.hs.toArray();
		kq = (String) o[vt];
		return kq;
	}

	public void inTatCa() {
		//C1: System.out.println(Arrays.toString(this.hs.toArray()));
		System.out.println(this.hs.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Do không thể gọi phương thức non static
		RutTham rt = new RutTham();
		while (true) {
			System.out.println("===========MENU===============");
			System.out.println("0.Kết thúc");
			System.out.println("1.Thêm mã số dự thưởng.");
			System.out.println("2.Xoá mã số dự thưởng");
			System.out.println("3.Kiểm tra mã số dự thưởng có tồn tại hay không?");
			System.out.println("4.Xoá tất cả các phiếu dự thưởng");
			System.out.println("5.Số lượng phiếu.");
			System.out.println("6.Lấy ra phiếu trúng thưởng.");
			System.out.println("7.In ra tất cả các phiếu.");
			System.out.println("Mời bạn nhập lựa chọn:");
			int lc = sc.nextInt();
			sc.nextLine();
			if (lc == 0)
				break;
			else if (lc == 1 || lc == 2 || lc == 3) {
				System.out.println("Nhập vào mã dự thưởng");
				String str = sc.nextLine();
				if (lc == 1)
					rt.themMaSoDuThuong(str);
				else if (lc == 2)
					rt.xoaPhieu(str);
				else
					System.out.println("Có tồn tại?" + rt.kiemTraPhieuTonTai(str));
			} else if (lc == 4)
				rt.xoaTatCaCacPhieu();
			else if (lc == 5)
				System.out.println("Số lượng phiếu dự thưởng:" + rt.laySoLuongPhieu());
			else if (lc == 6)
				System.out.println("Phiếu trúng thưởng là:" + rt.rutTham());
			else
				rt.inTatCa();
		}
	}
}
