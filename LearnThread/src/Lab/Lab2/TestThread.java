package Lab.Lab2;

public class TestThread {
	public static void main(String[] args) {
		oddThread odd= new oddThread();
		evenThread even=new evenThread();
		odd.start();
		try {
			odd.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		even.start();
	}
}
