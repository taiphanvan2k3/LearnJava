package sync;

public class myBank {
	private int money;

	public myBank(int money) {
		this.money = money;
	}

	//thêm synchronized để đưa các thread vào queue rồi thực hiện tuần tự
	public synchronized void withDraw(String name, int x) {
		if (x <= money) {
			System.out.println("Đã rút:" + x + " thread " + name);
			money -= x;
		} else
			System.out.println("Số tiền vượt quá số dư" + " thread " + name);
		System.out.println("Số tiền còn lại:" + money);
	}
}
