import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class KiThuatLapTrinh {
	public static int x = 5;

	public static void ham_getChars(String s) {
		char[] str = new char[100];
		s.getChars(0, 6, str, 0);
		for (char i : str)
			System.out.print(i);
	}

	public static void ham_getBytes(String s) {
		byte[] arrayBytes = s.getBytes();
		for (byte b : arrayBytes) {
			System.out.println(b);
		}
	}

	public static void ham_compareTo() {
		String s1 = "abc";
		String s2 = "od";
		System.out.println(s1.compareTo(s2));
	}

	public static void ham_regionMatches() {
		String s1 = "Codelearn";
		String s2 = "Learnjava";
		System.out.println(s1.regionMatches(false, 4, s2, 0, 5));
	}

	public static void ham_indexOf() {
		String s1 = "Xin chào các bạn,chào";
		// Biến thể 1:
		System.out.println(s1.indexOf('b'));
		// Biến thể 2:
		System.out.println(s1.indexOf("chào"));
		// Biến thể 3:
		System.out.println(s1.indexOf("chào", 10));
	}

	public static void ham_lastIndexOf() {
		String s1 = "hello abc ABc abc, tôi là abc Abc";
		// Tìm ra chuỗi abc xuất hiện đầu tiên từ phải sang
		System.out.println(s1.lastIndexOf("abc"));
	}

	public static void lam_viec_voi_mang(int[] a) {
		int[] b = a.clone();
		b[0] = 100;
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));

	}

	public static void methodSplit() {
		String s = "hello     	my name is Tai.I am 19 year old";
//		String ds[]=s.split("\\s+|\\.");
		String ds[] = s.split("[\\s.]+");
		for (String str : ds) {
			System.out.println(str);
		}
	}

	// ..................................
	public static Date StringToDate(String src, String pattern) throws ParseException {
		// C1:
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		// simpleDateFormat.applyPattern(pattern);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(src);
	}

	public static void StringToDateAndFormat() {
		String str = "24/03/2003";
		String pattern = "dd/MM/yyyy";
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			Date d = StringToDate(str, pattern);
			// Date d1= new Date(str);
			System.out.println(dateFormat.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// ........................
	public static void splitFunction() {
		String s = "Hello^My Name is Tai.I am 19 years old?akkaka}hihi";
		String ds[] = s.split("[.,}?^]");
		for (String string : ds) {
			System.out.println(string);
		}

		Pattern regex = Pattern.compile("java");
		Matcher matcher = regex.matcher("this is javaFx, do you know java");

		while (matcher.find()) {
			System.out.println(matcher.group() + " at index " + matcher.start());
		}

	}

	public static void StringToDate_part2() {
		String str = "24/03/2003";
		String pattern = "dd/MM/yyyy";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date d = simpleDateFormat.parse(str);
			simpleDateFormat.applyPattern("EEEE, dd-MM-yyyy");
			System.out.println(simpleDateFormat.format(d));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// .......................
	public static void MethodToString() {
		int arr[] = { 1, 2, 3, 4, 5 };
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		// a: là class rồi nên người ta đã xây dựng sẵn hàm toString
		System.out.println(a.toString());

		// Còn arr là 1 mảng int, do đó chưa có hàm toString
		// =>Dùng "ké" của Arrays
		System.out.println(Arrays.toString(arr));
	}

	public static void testGhiFileNhiPhan() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("test.data");
			String str = "Haizzz ko doc dc tieng viet";
			byte ds[] = str.getBytes();
			try {
				fos.write(ds);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void testDocFileNhiPhan() throws IOException {
		FileInputStream fis = new FileInputStream("test.data");
		int c;
		while ((c = fis.read()) != -1)
			System.out.print((char) c);
		fis.close();
	}

	public static void LearnDataOutputStream() throws IOException {
		FileOutputStream fos = new FileOutputStream("test.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("Xin chào các bạn");
		dos.writeInt(10);
		for (int i = 0; i < 10; i++)
			dos.writeInt(i);
		int a[] = { 1, 2, 3, 4, 5 };
		dos.flush();
		dos.close();
		fos.close();
	}

	public static void LearnDataInputStream() throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		DataInputStream dis = new DataInputStream(fis);
		int num = dis.readInt();
		System.out.println(num);
		for (int i = 0; i < num; i++) {
			System.out.print(dis.readInt() + " ");
		}
	}

	public static void singleCountDown() {
		Thread t = new Thread() {
			public void run() {
				int x = 120;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
				while (true) {
					Calendar d = Calendar.getInstance();
					d.setTimeInMillis(x * 1000);
					simpleDateFormat.applyLocalizedPattern("mm:ss");
					System.out.println(simpleDateFormat.format(d.getTime()));
					x--;
					try {
						Thread.sleep(998);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		};
		t.start();
	}

	public static void testNumberFormat(int x) {
		Locale lc = new Locale("vi", "vn");
		NumberFormat numberFormat = NumberFormat.getInstance(lc);
		System.out.println(numberFormat.format(x));
	}

	public static void testChange(ArrayList<Integer> a) {
		a.set(0, 100);
		a.add(2000);
	}

	// Giống cách làm việc với con trỏ
	public static void testChangeReference() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(4);
		a.add(5);
		System.out.println(a.toString());
		testChange(a);
		System.out.println(a.toString());
	}

	public static void doiTenFileHangLoai(int num) {
		for (int i = 1; i <= num; i++) {
			String url = "E:\\DUT\\Đề cuối kì\\OOP\\2\\cau_" + i + ".jpg";
			String url1 = "E:\\DUT\\Đề cuối kì\\OOP\\2\\câu_" + i + ".jpg";
			File f = new File(url);
			File f1 = new File(url1);
			f.renameTo(f1);
		}
	}

	public static void change(int a[]) {
		// Có tham chiếu
		a[0] = 100;
	}

	public static double test(double x, double y) throws Exception {
		if (y == 0)
			throw new Exception("Chia cho 0");
		return x / y;
	}

	public static void main(String[] args) {
		Base b= new Derived();
		b.show();
		b.display();
	}
}
