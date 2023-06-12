package sync_lesson2;

import java.util.Random;

public class threadT1 extends Thread {
	sharedData share;

	public threadT1(sharedData share) {
		this.share = share;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("T1 start");
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			synchronized (share) {
				int rand = rd.nextInt(100) + 1;
				System.out.println("T1 lần thứ " + (i+1) + ": "+ rand);
				share.setRand(rand);
				share.notifyAll();
				try {
					share.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Thread t1 stop");
		synchronized (share) {
			share.notifyAll();
		}
	}
}
