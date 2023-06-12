package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_FlowLayout extends JFrame {

	public ViDu_FlowLayout() {
		super.setTitle("FlowLayout");
		this.setSize(600, 400);
		// Để nằm giữa chương trình
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ViDu_FlowLayout fl = new ViDu_FlowLayout();
		FlowLayout flowLayOut = new FlowLayout();
		FlowLayout flowLayOut_1 = new FlowLayout(FlowLayout.RIGHT);
		FlowLayout flowLayOut_2 = new FlowLayout(FlowLayout.CENTER,20,30);
		fl.setLayout(flowLayOut_1);
		JButton button1 = new JButton("Ok");
		JButton button2 = new JButton("Cancel");
		JButton button3 = new JButton("Help");
		fl.add(button1);
		fl.add(button2);
		fl.add(button3);
	}
}
