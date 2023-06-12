package sync_lesson3;

public class threadT3 extends Thread {
	sharedData share;

	public threadT3(sharedData share) {
		this.share = share;
	}

	@Override
	public void run() {
		while (share.isContinueRand()) {
			synchronized (share) {
				share.notifyAll();
				try {
					// Nếu chưa đến lượt thread này chạy thì cho nó wait
					while (share.getIndex() != 3 && share.isContinueRand())
						share.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				int x = share.getX();
				if (x % 2 == 0) {
					if (x % 4 == 0)
						System.out.println("T3: Số ngẫu nhiên chia hết cho 4");
					else
						System.out.println("T3: Số ngẫu nhiên không chia hết cho 4");
				} else
					System.out.println("T3: Số ngẫu nhiên là số lẻ");

				share.setIndex(1);
			}

		}

		synchronized (share) {
			share.notifyAll();
		}
	}
}
