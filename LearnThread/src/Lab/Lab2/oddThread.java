package Lab.Lab2;

public class oddThread extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=9;i+=2) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println();
	}
}
