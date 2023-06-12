package sync_lesson3;

public class threadT2 extends Thread {
	sharedData share;

	public threadT2(sharedData share) {
		super();
		this.share = share;
	}

	@Override
	public void run() {
		while (share.isContinueRand()) {
			synchronized (share) {
				/*
				 * Các thread chạy sau thì đặt notifyAll lên đầu rồi cho nó wait
				 */

				share.notifyAll();
				try {
					// Nếu chưa đến lượt thread này chạy thì cho nó wait
					while (share.getIndex() != 2 && share.isContinueRand())
						share.wait();
				} catch (InterruptedException e) {
				}
				int x = share.getX();

				if (x % 3 == 0) {
					System.out.println("T2: " + x + "^2= " + x * x);
				}

				// Thực hiện xong nhiệm vụ của thread 2 => Đưa về thread1 để random ra số tiếp
				// theo
				share.setIndex(1);
			}
		}

		synchronized (share) {
			share.notifyAll();
		}
	}

}
