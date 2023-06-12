package Vidu;

public class Main {
	private static ThoiKhoaBieu tkb_t2;

	//Chuyển 1 xâu về kiểu enum
	public static void testMethodValuesOf() {
		DayOfWeek dow = DayOfWeek.valueOf("Monday");
		System.out.println(dow);
	}

	//Lấy ra tất cả các giá trị trong enum DayOfWeek
	public static void testMethodValues() {
		DayOfWeek[] ds = DayOfWeek.values();
		for (DayOfWeek dayOfWeek : ds) {
			System.out.println(dayOfWeek);
		}
	}

	public static void test() {
		tkb_t2 = new ThoiKhoaBieu(DayOfWeek.Monday, "Toán rời rạc-CTDL-Toeic");
		System.out.println(tkb_t2);
		System.out.println(Thang.Agust.getSoNgay());
		DayOfWeek dow = DayOfWeek.Friday;
		System.out.println(dow == DayOfWeek.Friday);

	}

	public static void main(String[] args) {

		testMethodValuesOf();
		System.out.println("->>>>>>test");
		testMethodValues();
	}
}
