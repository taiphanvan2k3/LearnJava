package File_p0;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class testScanner {
	public static void testScannerSysIn() {
		Scanner sc= new Scanner(System.in);
		int sum=0;
		while(sc.hasNextInt()) 
			sum+=sc.nextInt();
		System.out.println(sum);
	}
	public static void testScannerFile() throws IOException {
		Scanner sc = null;
		File f = new File("vd.txt");
		BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
		sc = new Scanner(br);
		//Nếu không có useDelimiter(...)thì nó mặc định sẽ ngăn
		//cách bởi dấu cách
		sc.useDelimiter("[.,\\s]+");
		while(sc.hasNext())
			System.out.println(sc.next());
	}
	public static void main(String[] args) throws IOException {
		testScannerSysIn();
	}
}
