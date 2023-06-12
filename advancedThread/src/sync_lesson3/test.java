package sync_lesson3;

public class test {
	public static void main(String[] args) {
		sharedData share= new sharedData();
		threadT1 t1=new threadT1(share);
		threadT2 t2=new threadT2(share);
		threadT3 t3=new threadT3(share);
		threadT4 t4=new threadT4(share);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
