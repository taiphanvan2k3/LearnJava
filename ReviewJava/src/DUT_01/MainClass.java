package DUT_01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//setting utf-8: -Dsun.stdout.encoding=UTF-8
public class MainClass {
	private Scanner sc = new Scanner(System.in);

	public static void test() {
		String str = "xin chào, hehe, kakak";
		String[] ds = str.split("[,\\s]+");
		System.out.println(ds.length);
		for (String x : ds) {
			System.out.println(x);
		}
	}

	private void bai1() {
		System.out.print("Nhập hệ số a: ");
		double a = sc.nextDouble();
		System.out.print("Nhập hệ số b: ");
		double b = sc.nextDouble();
		if (a == 0) {
			if (b == 0)
				System.out.println("Phương trình vô số nghiệm.");
			else
				System.out.println("Phương trình vô nghiệm.");
		} else
			System.out.println("Phương trình có nghiệm: x=" + (-b / a));
	}

	private void bai2() {
		System.out.print("Nhập hệ số a:");
		double a = sc.nextDouble();
		System.out.print("Nhập hệ số b:");
		double b = sc.nextDouble();
		System.out.print("Nhập hệ số c:");
		double c = sc.nextDouble();
		if (a == 0) {
			if (b == 0) {
				if (c == 0)
					System.out.println("Phương trình vô số nghiệm.");
				else
					System.out.println("Phương trình có nghiệm: " + (-b / a));
			} else
				System.out.println("Phương trình vô nghiệm.");
		} else {
			double delta = b * b - 4 * a * c;
			if (delta == 0)
				System.out.println("Phương trình có nghiệm kép x= " + (-b / (2 * a)));
			else if (delta < 0) {
				System.out.println("Phương trình vô nghiệm.");
			} else {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("x1= " + x1 + ",x2= " + x2);
			}
		}
	}

	private void bai3() {
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double min1, min2;
		if (a < b) {
			min1 = a;
			min2 = b;
		} else {
			min1 = b;
			min2 = a;
		}

		if (min2 > c)
			min2 = c;

		System.out.println(min2);
	}

	private void GiaiThuaKep() {
		int n = sc.nextInt();
		BigInteger gt = BigInteger.ONE;
		for (int i = n; i > 0; i -= 2) {
			gt = gt.multiply(new BigInteger(i + ""));
		}
		System.out.println(gt);
	}

	private boolean kiemTraSoNguyenTo() {
		BigInteger x = sc.nextBigInteger();
		return x.isProbablePrime(1000);
	}

	public static void main(String[] args) {
////		MainClass t = new MainClass();
////		t.GiaiThuaKep();
////		System.out.println("Chào Tài :)");
//		String str = "Ví dụ, trong các câu hỏi trắc nghiệm về khoa học hoặc toán học, các đáp án có thể có độ dài lớn hơn để cung cấp đầy đủ thông tin cho câu trả lời. Tuy nhiên, điều quan trọng là các đáp ";
//		System.out.println(str.length());
		Scanner sc = new Scanner(System.in);
		List<String> li = new ArrayList<>();
		for (int i = 1; i <= 55; i++) {
			String str = sc.nextLine();
			li.add(str);
		}
		String str[] = new String[] { "Kinh", "Tày", "Thái", "Hoa", "Khơ-me", "Mường", "Nùng", "HMông", "Dao",
				"Gia-rai", "Ngái", "Ê-đê", "Ba na", "Xơ-Đăng", "Sán Chay", "Cơ-ho", "Chăm", "Sán Dìu", "Hrê", "Mnông",
				"Ra-glai", "Xtiêng", "Bru-Vân Kiều", "Thổ", "Giáy", "Cơ-tu", "Gié Triêng", "Mạ", "Khơ-mú", "Co",
				"Tà-ôi", "Chơ-ro", "Kháng", "Xinh-mun", "Hà Nhì", "Chu ru", "Lào", "La Chí", "La Ha", "Phù Lá", "La Hủ",
				"Lự", "Lô Lô", "Chứt", "Mảng", "Pà Thẻn", "Co Lao", "Cống", "Bố Y", "Si La", "Pu Péo", "Brâu", "Ơ Đu",
				"Rơ măm", "Người nước ngoài" };
		String str2[]= new String[] {
			"Việt Nam","Lào","Campuchia","Thái Lan","Malaysia","Myanmar","Philippines","Đông Timor","Brunei","Singapore"
		};
	}
}
