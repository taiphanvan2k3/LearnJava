package DUT_08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UsingStream {
	private static void Example1() {
		try {
			FileInputStream fis = new FileInputStream(new File("input\\OOAD.pdf"));
			// Dùng BufferedInputStream để đọc xong vì mỗi lần đọc sẽ lưu vào bộ nhớ đệm
			// (Cache trên RAM), thay vì mỗi lần đọc lại vào bộ nhớ (SSD,HDD) để đọc dẫn đến
			// tốc độ đọc ghi nhanh hơn
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = new FileOutputStream(new File("input\\OOAD_copy.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int c;
			int count = 0;
			while ((c = bis.read()) != -1) {
				bos.write(c);
				count++;
				// Mỗi lần đọc là đọc một byte nên count cũng chính là dung lượng của file
			}
			System.out.println("Dung lượng của File: " + count);
			bis.close();
			bos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Example1();
	}
}
