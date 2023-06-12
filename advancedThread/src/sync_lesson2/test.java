package sync_lesson2;

public class test {
	public static void main(String[] args) {
		sharedData share= new sharedData();
		threadT1 t1=new threadT1(share);
		threadT2 t2=new threadT2(share);
		/*
		 * Yêu cầu với mỗi số sinh ra từ threadT1 thì đợi 
		 */
		t1.start();
		t2.start(); 
	}
}
