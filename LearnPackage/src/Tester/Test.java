package Tester;

import java.time.LocalDate;

import front_end.*;

public class Test {
	public static void main(String[] args) {
		ViDu v = new ViDu();
		// Nếu class giống ở 2 package thì dùng đường dẫn
		back_end.ViDu v1 = new back_end.ViDu();
		System.out.println(LocalDate.now());
	}
}
