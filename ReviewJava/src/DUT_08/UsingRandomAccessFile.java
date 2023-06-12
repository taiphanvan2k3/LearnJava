package DUT_08;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;

public class UsingRandomAccessFile {
	// Đối với việc làm với File có dữ liệu khá lớn 1TB chẳng hạn thì việc dùng
	// BufferedInputStream để lưu hết 1 lần đọc vào cache thì k chịu nổi
	// Do đó để làm file tối ưu thì sử dụng RandomAccessFile để cho phép nhảy đến 1
	// việc trí cụ thể trên file để đọc thay vì đọc tuần tự

	public static void main(String[] args) {
		try {
			// Đây chưa phải là cách dùng đúng nhất của RandomAccessFile.
			// Cần phải xây dụng chương trình da luồng để đọc file
			// Dùng seed để truy cập tại vị trí bất kỳ trong file
			RandomAccessFile fr = new RandomAccessFile(new File("input\\OOAD.pdf"), "r");
			FileOutputStream fos = new FileOutputStream(new File("input\\OOAD_copy2.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int c;
			while ((c = fr.read()) != -1)
				bos.write(c);
			bos.close();
			fos.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ReadFileThread extends Thread {
	@Override
	public void run() {

	}
}
