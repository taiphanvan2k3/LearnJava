package DUT_02;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicSplitPaneDivider;

public class Main {
	private static void test0() {
		String str = Integer.toBinaryString(12);
		System.out.println(str);
	}

	private static void test1() {
		String str = "h3llo";
		// str[1]='e'; error
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '3')
				sb.setCharAt(i, 'e');
			else {
				char c = (char) ((int) sb.charAt(i) - 32);
				sb.setCharAt(i, c);
			}
		}
		String temp = new String(sb);
		temp = temp.toLowerCase();
		System.out.println(sb.toString() + " after: " + temp);
	}

	private static void test2() {
		ArrayList<Object> ds = new ArrayList<>();

	}

	private static void show(double a, double b) throws Exception {
		if (b == 0)
			throw new Exception("Chia cho 0 kìa ");
		double temp = a / b;
		System.out.println(temp);
	}

	private static void show2(double a, double b) throws ArithmeticException {
		if (b == 0)
			throw new ArithmeticException("Mẫu là 0 kìa");
		System.out.println(a / b);
	}

	private static void showDataType() {
		Object[] ds = new Object[] { 10, "abc", 9.5, 'a', new Rabbit() };
		for (Object o : ds) {
			if (o instanceof Integer)
				System.out.println("int");
			else if (o instanceof String)
				System.out.println("String");
			else if (o instanceof Double)
				System.out.println("Double");
			else if (o instanceof Character)
				System.out.println("Character");
			else
				System.out.println("Other.");

		}

		// Duyệt ArrayList bằng Lamda
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(4);
		a.add(2);
		a.forEach(i -> {
			System.out.print(i + " ");
		});
	}

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().freeMemory());
	}
}
