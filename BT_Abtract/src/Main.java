
public class Main {
	public static void main(String[] args) {
		HangSanXuat h1 = new HangSanXuat("VN_01", "VietNam");
		HangSanXuat h2 = new HangSanXuat("Singapore_01", "Singapore");
		//Transport t1 = new Bicycle("Xe đạp", h1);
		Transport t2 = new Plane("VN airline", h2, "Xăng");
		//System.out.println(t1);
		System.out.println(t2);
	}
}
