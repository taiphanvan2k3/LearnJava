package sync_lesson2;

public class threadT2 extends Thread {
	sharedData share;

	public threadT2(sharedData share) {
		this.share = share;
	}

	@Override
	public void run() {
		System.out.println("T2 start");
		for (int i = 0; i < 10; i++) {
			synchronized (share) {
				share.notifyAll();
				try {
					share.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T2 lần thứ " + (i+1) + ": " + (int) Math.pow(share.getRand(), 2));
			}
		}

		System.out.println("Thread t2 stop");
		synchronized (share) {
			share.notifyAll();
		}
	}
}
