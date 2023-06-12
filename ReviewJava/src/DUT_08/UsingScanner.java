package DUT_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsingScanner {
	private static void example1() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				a[i][j] = sc.nextInt();
		}

		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	private static void example2() {
		try {
			Scanner sc = new Scanner(new File("Input\\data.txt"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

	}
}
