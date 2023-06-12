package main;

import java.text.NumberFormat;
import java.util.*;

/*
 Một người chơi sẽ có tài khoản. Người chơi có quyền đặt
 cược số tiền ít hơn họ đang có
 Luật chơi:
 Có 3 viên xúc xắc=> Mỗi lần sẽ thu được kết quả của 3 viên 
 xúc xắc (tính tổng lại)
 Th1: Nếu tổng =3 hoặc 18=> Cái ăn hết, người chơi thua
 Th2: nếu tổng=(4->10) <-> xỉu =>Nếu người chơi đặt xỉu thì
 người chơi thắng,không thì thua
 th3: nếu tổng=(11->17) (tài)=> Nếu người chơi đặt tài thì thắng
 */
public class TaiXiu {
	public static void menu() {
		player p = new player();
		Locale Lc = new Locale("en","US");
		//NumberFormat nf = NumberFormat.getInstance(Lc);
		NumberFormat nf = NumberFormat.getCurrencyInstance(Lc);
		Scanner sc = new Scanner(System.in);
		while (true && p.getMoney() != 0) {
			System.out.println("============ Mời bạn nhập lựa chọn ===========");
			System.out.println("Bạn có muốn chơi tiếp (1-0):");
			int lc = sc.nextInt();
			if (lc == 0) {
				System.out.println("Bye");
				break;
			}
			System.out.println("*** Bắt đầu chơi ***");
			System.out.println("Tài khoản của bạn hiện tại:" + nf.format(p.getMoney()));
			System.out.println("Bạn muốn đặt cược bao nhiêu?");
			double datCuoc;
			boolean checkError = false;
			do {
				if (checkError) {
					System.out.println("Số tiền vừa nhập không hợp lệ");
					System.out.println("Bạn chỉ có thể nhập [0," + nf.format(p.getMoney()) + "]");
					System.out.println("Mời bạn nhập lại:");
				} else
					System.out.println("Mời bạn đặt tiền cược:");
				datCuoc = sc.nextDouble();
				checkError = true;
			} while (!(datCuoc >= 0 && datCuoc <= p.getMoney()));
			int luaChonTaiXiu;
			System.out.println("Bạn vui lòng chọn (1<->Tài) hoặc (2<->Xỉu)");
			do {
				System.out.println("Nhập lựa chọn:");
				luaChonTaiXiu = sc.nextInt();
			} while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);
			// Tung xúc xắc
			Random xucXac = new Random();
			int gt1 = xucXac.nextInt(6) + 1;
			int gt2 = xucXac.nextInt(6) + 1;
			int gt3 = xucXac.nextInt(6) + 1;
			int sum = gt1 + gt2 + gt3;
			System.out.println("Kết quả:" + gt1 + " - " + gt2 + " - " + gt3);
			if (sum == 3 || sum == 18) {
				System.out.println("Tổng:" + sum + " =>Nhà cái ăn!");
				p.updateMoney(-datCuoc);
				System.out.println("Tài khoản của bạn là: " + nf.format(p.getMoney()));
			} else if ((sum >= 4 && sum <= 10)) {
				System.out.println("Tổng:" + sum + " =>XỈU");
				if (luaChonTaiXiu == 2) {
					System.out.println("Bạn thắng cược");
					p.updateMoney(datCuoc);
				} else {
					System.out.println("Bạn thua");
					p.updateMoney(-datCuoc);
				}
				System.out.println("Tài khoản của bạn là: " + nf.format(p.getMoney()));
			} else {
				System.out.println("Tổng:" + sum + " =>TÀI");
				if (luaChonTaiXiu == 1) {
					System.out.println("Bạn thắng cược");
					p.updateMoney(datCuoc);
				} else {
					System.out.println("Bạn thua");
					p.updateMoney(-datCuoc);
				}
				System.out.println("Tài khoản của bạn là: " + nf.format(p.getMoney()));
			}
		}
	}

	public static void main(String[] args) {
		menu();
	}
}
