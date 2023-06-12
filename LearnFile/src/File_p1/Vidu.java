package File_p1;

import java.io.File;
import java.io.IOException;

public class Vidu {
	public static void main(String[] args) {
		// Khởi tạo đối tượng foler1 bằng cách dùng toán tử new(đường dẫn đến thư mục)
		File foler1 = new File("E:\\BtJava\\LearnFile");
		// Phương thức exists
		System.out.println("Kiểm tra tồn tại thư mục foler1:" + foler1.exists());
		
		//Tạo ra nhiều thư mục liên tiếp dẫn đến thư mục cuối
		File foler2 = new File("E:\\BtJava\\LearnFile\\file_1\\file_2");
		foler2.mkdirs();
		File file1 = new File("E:\\Btjava\\LearnFile\\vd1.xls");
		File file2 = new File("E:\\BtJava\\LearnFile\\file_1\\file_2\\vd.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Kiểm tra tồn tại tệp tin file2:" + file2.exists());
	}
}
