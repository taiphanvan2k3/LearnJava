package Lab.Lab2;

public class evenThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<=10;i+=2) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				break;
			}
		}
		
	}
}
