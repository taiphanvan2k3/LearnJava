import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoadingExample extends JFrame {

	private LoadingScreen loading;
	private JButton btnStart;
	private JLabel lbl;

	public LoadingExample() {
		this.setSize(300, 150);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loading = new LoadingScreen();
		loading.setLayout(new BorderLayout());
		lbl = new JLabel();
		lbl.setHorizontalAlignment(JLabel.RIGHT);
		loading.add(lbl, BorderLayout.SOUTH);
		this.add(loading, BorderLayout.CENTER);
		btnStart = new JButton("Start");
		this.add(btnStart, BorderLayout.SOUTH);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadingThread thread = new LoadingThread(loading);
				thread.start();
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new LoadingExample();
	}

	private class LoadingScreen extends JPanel {
		int step = 0;
		int max_step = 20;

		public boolean isCompleted() {
			return step == max_step;
		}

		public void resetStep() {
			step = 0;
		}

		public void updateStatus() {
			step++;
			lbl.setText(step * 100 / max_step + " %");
			switch (step) {
			case 0:
				// do something
				break;
			case 1:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			}
			repaint();
		}

		public void paint(Graphics g) {
			// Vẽ lại nền cho panel tránh trường hợp
			super.paint(g);
			g.setColor(Color.gray);
			g.fillRect(0, 20, this.getWidth(), 40);
			g.setColor(Color.red);
			g.fillRect(0, 20, this.getWidth() * step / max_step, 40);
		}
	}

	private class LoadingThread extends Thread {
		private LoadingScreen loading;

		public LoadingThread(LoadingScreen loading) {
			this.loading = loading;
		}

		@Override
		public void run() {
			loading.resetStep();
			btnStart.setEnabled(false);
			while (!loading.isCompleted()) {
				try {
					Random r = new Random();
					Thread.sleep(150 * (r.nextInt(5) + 1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loading.updateStatus();
			}
			btnStart.setEnabled(true);
		}
	}
}