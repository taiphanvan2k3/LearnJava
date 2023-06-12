package Lab.Lab3;

import java.util.Date;
import java.util.Random;

import javax.swing.JTextField;

public class randomThread extends Thread{
	private JTextField textFileShow;
	
	public randomThread(JTextField textFileShow) {
		this.textFileShow = textFileShow;
	}

	public void run() {
		Date now= new Date();
		Random r = new Random(now.getTime());
		for (int i = 1; i <= 1000; i++) {
			textFileShow.setText(r.nextInt(10) + "");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
