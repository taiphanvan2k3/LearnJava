import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) {
		for (int i = 0; i < 3600; i++) {
			printTimeToScreen(i * 1000);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void printTimeToScreen(int miliSecond) {
		
	}
}
