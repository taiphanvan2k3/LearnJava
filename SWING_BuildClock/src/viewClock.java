import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class viewClock extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JLabel lblShowTime;
	private timerThread t;
	private long miliSecondsCounted;
	private int timeTarget = 1;
	private Stack<Integer> st = new Stack<>();
	private JButton btnResume;
	private JButton btnPause;
	private JButton btnStop;
	private JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new viewClock();
	}

	/**
	 * Create the frame.
	 */
	public viewClock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 280);
		this.setLocation(450, 50);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setVisible(true);
		btnStart = new JButton("Start");
		btnStart.setMnemonic('S');

		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 16));

		btnStop = new JButton("Stop");

		btnStop.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1 minutes", "2 minutes", "5 minutes", "10 minutes", "15 minutes" }));
		comboBox.setSelectedIndex(0);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// t.setMinutesTarget(ABORT);
				String selected = (String) comboBox.getSelectedItem();
				String ds[] = selected.split(" ");
				timeTarget = Integer.valueOf(ds[0]);
				if (t != null)
					t.setMinutesTarget(timeTarget);
			}
		});

		lblShowTime = new JLabel();
		lblShowTime.setForeground(Color.BLUE);
		lblShowTime.setBackground(Color.WHITE);
		lblShowTime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShowTime.setHorizontalAlignment(SwingConstants.CENTER);

		btnPause = new JButton("Pause");

		btnPause.setFont(new Font("Times New Roman", Font.BOLD, 16));

		btnResume = new JButton("Resume");

		btnResume.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(31)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblShowTime, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 209,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 93,
														GroupLayout.PREFERRED_SIZE)
												.addGap(31).addComponent(btnResume)))))
				.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
				.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(41)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(38)
				.addComponent(lblShowTime, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnStart)
						.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStop)
						.addComponent(btnResume, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addGap(52)));
		contentPane.setLayout(gl_contentPane);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startThread();
			}
		});

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopThread();
			}
		});

		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseThread();
			}
		});

		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resumeThread();
			}
		});

		/*
		 * Do khi bấm vào component rồi thì khi nhấn ctrl X ko đc nữa do đó ta add sự
		 * kiện cho các keyListener cho các button đó luôn để luôn nhấn đc ctrl X
		 */
		btnStart.addKeyListener(this);
		btnPause.addKeyListener(this);
		btnResume.addKeyListener(this);
		btnStop.addKeyListener(this);
		comboBox.addKeyListener(this);
		this.addKeyListener(this);

		// Ban đầu ko cho btnResume chạy
		btnResume.setEnabled(false);
		btnPause.setEnabled(false);
		btnStop.setEnabled(false);
	}

	private void startThread() {
		if (t != null)
			stopThread();
		t = new timerThread(lblShowTime);
		btnStart.setEnabled(false);
		btnPause.setEnabled(true);
		btnStop.setEnabled(true);
		t.start();
	}

	@SuppressWarnings("deprecation")
	private void stopThread() {
		if (t != null) {
			t.printTimeToScreen(0);
			this.miliSecondsCounted = 0;
			btnStart.setEnabled(true);
			btnPause.setEnabled(false);
			btnStop.setEnabled(false);
			t.stop();
			t = null;
		}
	}

	private void pauseThread() {
		if (t != null) {
			miliSecondsCounted = t.getMiliSecondCounted();
			t.stop();
			btnResume.setEnabled(true);
			btnPause.setEnabled(false);
		}
	}

	private void resumeThread() {
		t = new timerThread(lblShowTime, timeTarget, miliSecondsCounted);
		t.start();
		btnResume.setEnabled(false);
		btnPause.setEnabled(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// việc có thể nhấn giữ nên nếu phần tử đầu stack giống với
		// key mình vừa nhấn thì
		if (st.size() == 0 || (st.size() != 0 && st.peek() != key))
			st.add(key);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (st.size() >= 2 && key == KeyEvent.VK_X && st.get(0) == KeyEvent.VK_CONTROL)
			System.exit(0);
		System.out.println(st.toString());
		st.clear();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
