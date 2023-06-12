package sync;

public class withDrawThread extends Thread {
	myBank bank;
	String name;

	public withDrawThread(myBank bank, String name) {
		this.name = name;
		this.bank = bank;
	}

	@Override
	public void run() {
		bank.withDraw(name, 800);
	}
}
