package sync_lesson3;

public class threadT4 extends Thread {
	sharedData share;

	public threadT4(sharedData share) {
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
					while (share.getIndex() != 4 && share.isContinueRand())
						share.wait();
				} catch (InterruptedException e) {
				}

				int x = share.getX();
				if (x % 2 == 1)
					System.out.println("T4: " + x + " là số lẻ");
				// Thực hiện xong nhiệm vụ của thread 2
				// => Đưa về thread1 để random ra số tiếp theo
				share.setIndex(1);
			}
		}

		synchronized (share) {
			share.notifyAll();
		}
	}

}
