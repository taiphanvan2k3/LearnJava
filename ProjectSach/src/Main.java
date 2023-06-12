import java.util.Scanner;
public class Main {
	private int num=0;
	private static Scanner sc;
	public static void nhap_ds() {
		while(true) {
			int lc;
			System.out.println("Nhập lựa chọn (1/0)");
			lc=Integer.parseInt(sc.nextLine());
			if(lc==0) break;
			book b=new book();
		}
	}
	public static void main(String[] args) {
//		sc=new Scanner(System.in);
//		Date d=new Date(1,1,1999);
//		TacGia tg=new TacGia("Nguyen Van A", d);
//		book b=new book("Conan",20,1999,tg);
//		listBook l1=new listBook();
//		l1.insertBook(b);
//		l1.getList()[0].display();
		book a=new book();
		a.nhap_tt();
		a.display();
	}
}
