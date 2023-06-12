package File_p2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViDu {
	private File file;

	public ViDu(String tenFile) {
		this.file = new File(tenFile);
	}

	public File getFile() {
		return this.file;
	}

	public boolean checkCanExcute() {
		return this.file.canExecute();
	}

	public boolean checkCanRead() {
		return this.file.canRead();
	}

	public boolean checkCanWrite() {
		return this.file.canWrite();
	}

	public String inTenDuongDan() {
		return this.file.getAbsolutePath();
	}

	public String inTenFile() {
		return this.file.getName();
	}

	public void checkFileOrFolder() {
		if (this.file.isFile())
			System.out.println("Đường dẫn dẫn tới một file");
		else
			System.out.println("Đường dẫn dẫn tới một thư mục");
	}

	public void inDanhSachFileCon() {
		if (this.file.isFile())
			System.out.println("Đây là tập tin => Không có tập tin con");
		else
			System.out.println("Các tập tin/thư mục con là:");

		File[] ds = this.file.listFiles();
		for (File f : ds)
			System.out.println(f.getAbsolutePath());
	}

	public void inRaCayThuMuc() {
		System.out.println(this.file.getName());
		this.inChiTiet(this.file, "\t");
	}
	public void inChiTiet(File f,String tab) {
		if (f.isDirectory()) {
			File[] ds = f.listFiles();
			for (File i : ds) {
				System.out.println(tab + i.getName());
				inChiTiet(i, tab.concat("\t"));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên file muốn thao tác:");
		String tenFile = sc.nextLine();
		ViDu v = new ViDu(tenFile);
		while (true) {
			System.out.println("===========MENU============");
			System.out.println("0.Thoát chương trình");
			System.out.println("1.Kiểm tra file có thể thực thi.");
			System.out.println("2.Kiểm tra file có thể đọc.");
			System.out.println("3.Kiểm tra file có thể ghi.");
			System.out.println("4.In đường dẫn");
			System.out.println("5.In tên file");
			System.out.println("6.Kiểm tra đường dẫn dẫn đến file hay thư mục");
			System.out.println("7.In ra danh sách các file con");
			System.out.println("8.In ra cây thư mục");
			System.out.print("Mời bạn nhập lựa chọn:");
			int lc = sc.nextInt();
			sc.nextLine();
			if (lc == 0)
				break;
			else if (lc == 1)
				System.out.println("Có thể thực thi: " + v.checkCanExcute());
			else if (lc == 2)
				System.out.println("Có thể đọc: " + v.checkCanRead());
			else if (lc == 3)
				System.out.println("Có thể ghi: " + v.checkCanWrite());
			else if (lc == 4)
				System.out.println("Đường dẫn: " + v.inTenDuongDan());
			else if (lc == 5)
				System.out.println(v.inTenFile());
			else if (lc == 6)
				v.checkFileOrFolder();
			else if (lc == 7)
				v.inDanhSachFileCon();
			// Vai trò như system("pause") để dừng màn hình
			// lại xem 1 lát rồi mới chạy while tiếp
			else if (lc == 8)
				v.inRaCayThuMuc();
			sc.nextLine();

		}
	}
}
