package Test;

import java.util.Scanner;

import Code.DanhSachSv;
import Code.SinhVien;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachSv danhSach = new DanhSachSv();
		while (true) {
			System.out.println("============ Mời bạn nhập lựa chọn ===========");
			System.out.println("0.Thoát");
			System.out.println("1.Thêm sinh viên vào danh sách");
			System.out.println("2.In danh sách sinh viên ra màn hình");
			System.out.println("3.Kiểm tra danh sách có rỗng hay không?");
			System.out.println("4.Lấy số lượng sinh viên trong danh sách");
			System.out.println("5.Làm rỗng danh sách sinh viên");
			System.out
					.println("6.Kiểm tra sinh viên có tồn tại trong danh sách hay không," + "dựa trên mã số sinh viên");
			System.out.println("7.Xoá một sinh viên ra khỏi danh sách dựa theo mã số sinh viên");
			System.out.println("8.Tìm kiếm sinh viên theo tên");
			System.out.println("9.Xuất danh sách sinh viên có điểm từ cao đến thấp");
			System.out.print("Mời bạn nhập lựa chọn:");
			int lc = sc.nextInt();
			sc.nextLine();
			if (lc == 0)
				break;
			else if (lc == 1) {
				System.out.println("Nhập mã sinh viên:");
				String mssv = sc.nextLine();
				System.out.println("Nhập họ tên:");
				String ht = sc.nextLine();
				System.out.println("Nhập năm sinh:");
				int namSInh = sc.nextInt();
				System.out.println("Nhập điểm trung bình");
				double gpa = sc.nextDouble();
				SinhVien sv = new SinhVien(mssv, ht, namSInh, gpa);
				danhSach.themSinhVien(sv);
			} else if (lc == 2) {
				if(danhSach.kiemTraDachSachrong())
					System.out.println("Danh sách đang rỗng.");
				else {
					System.out.println("Các sinh viên có trong danh sách:");
					danhSach.inDanhSach();
				}
			} else if (lc == 3) {
				if (danhSach.kiemTraDachSachrong())
					System.out.println("Danh sách đang rỗng.");
				else
					System.out.println("Số lượng hiện tại:" + danhSach.soLuongSinhVien());
			} else if (lc == 4) {
				System.out.println("Số lượng hiện tại:" + danhSach.soLuongSinhVien());
			}else if(lc==5) {
				danhSach.xoaTatCaSinhVien();
			}else if(lc==6) {
				String mssv;
				System.out.println("Nhập mã số sinh viên cần tìm kiếm:");
				mssv=sc.nextLine();
				SinhVien sv=new SinhVien(mssv);
				//C1:
				//System.out.println("Kết quả tìm kiếm:"+danhSach.timKiemTheoMSSV(mssv));
				
				System.out.println("Kết quả tìm kiếm:"+danhSach.timKiemTheoMSSV(sv));
			}else if(lc==7) {
				System.out.println("Nhập mã số sinh viên cần xoá:");
				String mssv=sc.nextLine();
				SinhVien sv=new SinhVien(mssv);
				//C1:danhSach.xoaSinhVienTheoMSSV(mssv);
				danhSach.xoaSinhVienTheoMSSV(sv);
			}else if(lc==8) {
				System.out.println("Nhập tên sinh viên cần tìm kiếm:");
				String ten=sc.nextLine();
				danhSach.timKiemTheoTen(ten);
			}else {
				danhSach.inDanhSachGiamDanTheoGPA2();
				danhSach.inDanhSach();
			}
		}
	}
}
