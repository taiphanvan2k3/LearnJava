import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class timerThread extends Thread {
	private JLabel show;
	private int minutesTarget;
	private long miliSecondCounted;
	private boolean checkCanContinue = true;
	private int hours;
	private int minutes;
	private int seconds;

	public timerThread(JLabel show) {
		this.show = show;
		this.minutesTarget = 1;
		this.miliSecondCounted = 0;
	}

	public timerThread(JLabel show, int minutesTarget) {
		super();
		this.show = show;
		this.minutesTarget = minutesTarget;
	}

	public timerThread(JLabel show, int minutesTarget, long miliSecondCounted) {
		super();
		this.show = show;
		this.minutesTarget = minutesTarget;
		this.miliSecondCounted = miliSecondCounted;
	}

	public long getMiliSecondCounted() {
		return (hours * 3600 + minutes * 60 + seconds) * 1000;
	}

	public void setMiliSecondCounted(long miliSecondCounted) {
		this.miliSecondCounted = miliSecondCounted;
	}

	public int getMinutesTarget() {
		return minutesTarget;
	}

	public void setMinutesTarget(int minutesTarget) {
		this.minutesTarget = minutesTarget;
	}

	@Override
	public void run() {
		long timeCurent = System.currentTimeMillis();
		while (true) {
			int deltaTime = (int) (System.currentTimeMillis() - timeCurent);
			printTimeToScreen(deltaTime + miliSecondCounted);
			if (!checkCanContinue) {
				JOptionPane.showMessageDialog(show, "Đã đến giờ rồi !!!");
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void printTimeToScreen(long miliSecond) {
		hours = (int) ((miliSecond / 1000) / 3600);
		minutes = (int) ((miliSecond / 1000 - 3600 * hours) / 60);
		seconds = (int) (miliSecond / 1000 - 3600 * hours - 60 * minutes);
		Date d = new Date();
		d.setHours(hours);
		d.setMinutes(minutes);
		d.setSeconds(seconds);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		show.setText(df.format(d));
		if (minutes >= minutesTarget)
			checkCanContinue = false;
	}

}
