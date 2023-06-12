package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_GridLayout extends JFrame {

	public ViDu_GridLayout() {
		super.setTitle("GridLayout");
		this.setSize(600, 400);
		// Để nằm giữa chương trình
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ViDu_GridLayout fl = new ViDu_GridLayout();
		GridLayout gridLayOut = new GridLayout();
		GridLayout gridLayOut_1 = new GridLayout(4,4);//4 hàng, 4 cột
		GridLayout gridLayOut_2 = new GridLayout(4, 1, 25, 25);
		fl.setLayout(gridLayOut_2);
		for(int i=1;i<=4;i++) {
			JButton bt=new JButton(i+"");
			fl.add(bt);
		}
	}
}
