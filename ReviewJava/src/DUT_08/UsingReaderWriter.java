package DUT_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UsingReaderWriter {
	private static void example1() {
		try {
			// Đọc theo từng kí tự, mỗi lần đọc thì phải truy cập vào bộ nhớ để đọc, đọc
			// xong chuyển qua cho FileWriter để ghi
			FileReader fr = new FileReader(new File("input\\data.txt"));
			FileWriter fw = new FileWriter(new File("input\\output.txt"));
			int x = -1;
			while ((x = fr.read()) != -1) {
				fw.write(x);
			}
			fw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void example1_2() {
		try {
			// Dùng bộ đệm để đọc cho nhanh thay vì mỗi lần dùng FileReader đọc từng byte từ
			// bộ nhớ ngoài thì giờ dùng br để đọc xong lưu vào Cache
			FileReader fr = new FileReader(new File("input\\hovaten.txt"), StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(fr);

			List<Info> ds = new ArrayList<>();
			while (true) {
				String str = br.readLine();
				if (str == null || str == "")
					break;
				ds.add(new Info(str));
			}

			Collections.sort(ds);

			// Dùng bộ đệm để ghi -> Cải thiện hiệu suất hơn việc chỉ dùng mỗi FileWriter
			FileWriter fw = new FileWriter(new File("input\\hovatenOutput.txt"), StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Info info : ds) {
				String str = info.name + ", " + info.yearsOld;
				bw.write(str);
				bw.newLine();
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void example2() {
		try {
			// Đọc từng byte một, đọc xong chuyển qua cho FileOutputStream byte đó, tốc độ
			// chậm. Cách tiếp cận này tương tự việc chỉ dùng với FileReader và FileWriter 
			FileInputStream fr = new FileInputStream(new File("input\\data.txt"));
			FileOutputStream fw = new FileOutputStream(new File("input\\output.txt"));
			int x = -1;
			while ((x = fr.read()) != -1) {
				fw.write(x);
			}
			fw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void example3() {
		try {
			// Mỗi lần đọc 1 byte thì chuyển sang 1 kí tự. Để chuyển được như vậy thì phải
			// thông qua trung gian InputStreamReader
			FileInputStream fis = new FileInputStream(new File("input\\data.txt"));
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream(new File("input\\output.txt"));
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);

			int x;
			// while((x=))

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		example1_2();
	}
}

class Info implements Comparable<Info> {
	String name;
	int yearsOld;

	public Info(String str) {
		String[] ds = str.split(", ");
		name = ds[0];
		yearsOld = Integer.valueOf(ds[1]);
	}

	@Override
	public int compareTo(Info o) {
		return this.yearsOld - o.yearsOld;
	}
}