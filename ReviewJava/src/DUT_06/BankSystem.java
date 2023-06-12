package DUT_06;

public class BankSystem {
	private int NganKho = 10000;

	public int getNganKho() {
		return NganKho;
	}

	public void setNganKho(int nganKho) {
		NganKho = nganKho;

	}

	public BankSystem() {
		ATM a1 = new ATM(this, "Hoà khánh");
		a1.start();

		ATM a2 = new ATM(this, "Hải Châu");
		a2.start();
	}

	public static void main(String[] args) {
		new BankSystem();
	}
}

class ATM extends Thread {
	BankSystem bank;
	String name;

	public ATM(BankSystem bank, String name) {
		this.bank = bank;
		this.name = name;
	}

	public void RutTien() {
		//Có khả năng xung đột nên phải bao bọc bởi synchronized
		synchronized (bank) {
			bank.setNganKho(bank.getNganKho() - 10);
			System.out.println(name + " rút tiền, ngân hàng còn lại:" + bank.getNganKho());
		}
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			RutTien();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
