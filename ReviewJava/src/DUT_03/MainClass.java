package DUT_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
	private static void test01() {
		ArrayList<Object> a = new ArrayList<>();
		a.add("3");
		a.add(12);
		a.add('a');

		HashMap<String, String> hash = new HashMap<>();
		hash.put("abc", "12");
		for (Map.Entry<String, String> entry : hash.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	public static void main(String[] args) {
		ArrayList<HoTen> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str=sc.nextLine();
			if(str.equals(""))
				break;
			HoTen ht= new HoTen(str);
			list.add(ht);
		}
		
		Collections.sort(list);
		for (HoTen hoTen : list) {
			System.out.println(hoTen);
		}
	}
}
