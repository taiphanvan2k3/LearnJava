package Test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class ThreadCounter extends JFrame implements Runnable {

	private JPanel contentPane;
	private JButton btnCounter;
	private Thread t1, t2;

	public static void main(String[] args) {
		ThreadCounter test = new ThreadCounter();
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			btnCounter.setText(count + "");
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	public ThreadCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCounter = new JButton("Count");
		btnCounter.setBackground(new Color(0, 191, 255));
		btnCounter.setForeground(Color.BLACK);
		btnCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCounter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ko dùng đc this.initThread()
				initThread();
				System.out.println(Thread.activeCount());
			}
		});
		btnCounter.setBounds(178, 70, 98, 37);
		contentPane.add(btnCounter);

		JButton btnCounter2 = new JButton("Count 2");
		btnCounter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (t2 == null) {
					// Dùng cách tạo thread nặc danh
					t2 = new Thread() {
						public void run() {
							int count = 50;
							while (true) {
								btnCounter2.setText(count + "");
								count--;
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									break;
								}
							}
						}
					};
					System.out.println(Thread.activeCount());
					t2.start();
				}
			}
		});
		btnCounter2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCounter2.setBounds(178, 158, 98, 37);
		contentPane.add(btnCounter2);
		this.setVisible(true);
	}

	public void initThread() {
		if (t1 == null) {
			t1 = new Thread(this);
			t1.start();
		}
	}
}
