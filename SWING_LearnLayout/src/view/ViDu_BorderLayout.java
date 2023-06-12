package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_BorderLayout extends JFrame {

	public ViDu_BorderLayout() {
		super.setTitle("BorderLayout");
		this.setSize(600, 400);
		// Để nằm giữa chương trình
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ViDu_BorderLayout borderLayout = new ViDu_BorderLayout();
		BorderLayout borderLayOut_1 = new BorderLayout();
		BorderLayout borderLayOut_2 = new BorderLayout(10, 10);
		borderLayout.setLayout(borderLayOut_2);
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		borderLayout.add(button1, BorderLayout.NORTH);
		borderLayout.add(button2, BorderLayout.EAST);
		borderLayout.add(button3,BorderLayout.WEST);
		borderLayout.add(button4,BorderLayout.CENTER);
		borderLayout.add(button5,BorderLayout.SOUTH);
	}
}
