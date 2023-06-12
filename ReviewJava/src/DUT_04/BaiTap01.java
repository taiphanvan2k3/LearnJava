package DUT_04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaiTap01 extends JFrame implements ActionListener {
	JPanel pnlButton = new JPanel();

	public void initComponents() {
		this.setSize(500, 300);
		this.setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public BaiTap01() {
		this.initComponents();
		this.add(pnlButton, BorderLayout.NORTH);

		JButton btnGreen = new JButton("Green");
		btnGreen.addActionListener(this);
		JButton btnBlue = new JButton("Blue");
		btnBlue.addActionListener(this);
		JButton btnRed = new JButton("Red");
		btnRed.addActionListener(this);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this);

		pnlButton.setLayout(new FlowLayout());
		pnlButton.add(btnGreen);
		pnlButton.add(btnBlue);
		pnlButton.add(btnRed);
		pnlButton.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Green")) {
			pnlButton.setBackground(Color.green);
			this.getContentPane().setBackground(Color.green);
		}

		else if (src.equals("Blue")) {
			pnlButton.setBackground(Color.blue);
			this.getContentPane().setBackground(Color.blue);
		}
		else if (src.equals("Red")) {
			pnlButton.setBackground(Color.red);
			this.getContentPane().setBackground(Color.red);
		} else {
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new BaiTap01();
	}
}
