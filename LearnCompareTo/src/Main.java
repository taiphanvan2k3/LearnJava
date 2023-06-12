import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(1, "Nguyen Van Thanh", "12/1", 9);
		SinhVien sv2 = new SinhVien(2, "Ho Van Hieu", "12/1", 8.5);
		SinhVien sv3 = new SinhVien(3, "Nguyen Dinh Anh Tien", "12/10", 9.2);
		SinhVien sv4 = new SinhVien(4, "Phan Van Tai", "12/1", 8.8);
		SinhVien[] ds = { sv1, sv2, sv3, sv4 };
		Arrays.sort(ds);
		System.out.println(Arrays.binarySearch(ds, sv1));
		for (SinhVien sv : ds)
			System.out.println(sv);
	}
}
