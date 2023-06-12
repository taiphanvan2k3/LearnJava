package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testLamda {
	private static void example() {
		/*
		 * Cấu trúc của biểu thức lamda
		 * (arguments) -> {statement/s}
		 */
		
		// Nếu k dùng Lamda
		MyInterface myInterface = new MyInterface() {
			@Override
			public void show() {
				System.out.println("Show gì đây");
			}
		};
		myInterface.show();

		// Còn nếu dùng Lamda
		MyInterface myInterface2 = () -> System.out.println("Chẳng biết show gì cả !!!");
		myInterface2.show();

		MyInterface i3 = () -> {
			System.out.println("Xin chào các bạn :))");
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(df.format(d));
		};
		i3.show();
	}

	private static void test1() {
		Printable_2 t = s -> "Đây là test 01 với nội dung: " + s;
		System.out.println(t.doThing("test 01"));
	}

	private static void test2() {
		Printable t = s -> System.out.println("Đây là test 02 với nội dung: " + s);
		t.show("nothing");
	}

	private static void test3() {
		Printable_3 t = (s1, s2) -> System.out.println(s1 + " và " + s2);
		t.show("Tom", "Jerry");
	}

	public static void main(String[] args) {
		example();
	}
}
