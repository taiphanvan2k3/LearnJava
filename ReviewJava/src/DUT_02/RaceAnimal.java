package DUT_02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class RaceAnimal extends JFrame {

	private JPanel contentPane;
	Thread threadRan, threadRua, threadTho;
	private JButton btnRua;
	private JButton btnRan;
	private JButton btnTho;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaceAnimal frame = new RaceAnimal();
					frame.setVisible(true);
					frame.setSpeed();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RaceAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 143, 985, 17);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 356, 985, 2);
		contentPane.add(separator_1);

		btnRan = new JButton("Rắn");
		btnRan.setBackground(new Color(0, 128, 0));
		btnRan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRan.setBounds(49, 38, 85, 61);
		contentPane.add(btnRan);

		btnRua = new JButton("Rùa");
		btnRua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRua.setBounds(49, 231, 85, 61);
		contentPane.add(btnRua);

		btnTho = new JButton("Thỏ");
		btnTho.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTho.setBounds(49, 428, 85, 61);
		contentPane.add(btnTho);

		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(995, 10, 6, 521);
		contentPane.add(separator_2);
	}

	private void setSpeed() {
		threadRan = new Thread() {
			public void run() {
				while (true) {
					btnRan.setLocation(btnRan.getX() + 8, btnRan.getY());
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		threadRan.start();

		threadRua = new Thread() {
			public void run() {
				while (true) {
					btnRua.setLocation(btnRua.getX() + 4, btnRua.getY());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadRua.start();

		threadTho = new Thread() {
			public void run() {
				while (true) {
					btnTho.setLocation(btnTho.getX() + 10, btnTho.getY());
					if (btnTho.getX() + btnTho.WIDTH >= 1000) {
						threadRan.stop();
						threadRua.stop();
						break;
					}
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadTho.start();
	}
}
