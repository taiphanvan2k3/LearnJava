package sync_lesson3;

import java.util.Random;

public class threadT1 extends Thread {
	private sharedData share;

	public threadT1(sharedData share) {
		this.share = share;
	}

	@Override
	public void run() {
		// Để chương trình thực hiện đúng thì cho 2 thread kia vào while trước
		// còn thread t1 vào sau

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Random r = new Random();
		while (share.isContinueRand()) {
			synchronized (share) {
				int x = r.nextInt(100) + 1;
				System.out.println("T1: " + x);
				share.addSum(x);
				share.setX(x);
				if (x % 3 == 0)
					share.setIndex(2);
				else if (x % 2 == 0)
					share.setIndex(3);
				else
					share.setIndex(4);
				share.notifyAll();
				try {
					share.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized (share) {
			share.notifyAll();
		}
	}
}
