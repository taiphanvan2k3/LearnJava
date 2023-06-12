package Lab;

public class Test {
	public static void main(String[] args) {
		
		MyThread thread1 = new MyThread("t1",10);
		Thread t1 = new Thread(thread1);
		t1.setPriority(Thread.MIN_PRIORITY);
		
		//Do MyThread implements Runable chứ không
		//extends Thread nên không có phương thức của Thread
		MyThread thread2 = new MyThread("t2",20);
		Thread t2 = new Thread(thread2);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
		//Thread1 được tạo ra trước thread2
		//Nhưng do thread2 có độ ưu tiên cao hơn
		//nên nó sẽ được ưu tiên thực hiện trước
		//thread1
	}
}
