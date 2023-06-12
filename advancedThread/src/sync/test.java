package sync;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		myBank bank= new myBank(1000);
		ArrayList<withDrawThread>ds= new ArrayList<>();
		for(int i=0;i<100;i++) {
			ds.add(new withDrawThread(bank,"thread "+i));
		}
		for(int i=0;i<100;i++) {
			ds.get(i).start();
		}
	}
}
