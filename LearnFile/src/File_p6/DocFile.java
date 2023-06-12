package File_p6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DocFile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String str = sc.next();
//		//C1: Đọc file bằng class BufferedReader
		File f = new File("E:\\BtJava\\phienam.txt");
//		try {
//			BufferedReader br = Files.newBufferedReader(f.toPath());
//			while (true) {
//				String s = br.readLine();
//				if (s == null)
//					break;
//				System.out.println(s);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// C2: DÙng class Files
		try {
			List<String> lines = Files.readAllLines(f.toPath());
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
