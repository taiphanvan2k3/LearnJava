package Lab;

public class MyThread implements Runnable {

	private int cnt;
	private String c;

	public MyThread(String c,int cnt) {
		this.cnt = cnt;
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(i + " " + c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
