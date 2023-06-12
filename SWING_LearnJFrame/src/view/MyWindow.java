package view;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	MyWindow() {
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Show(String title) {
		super.setTitle(title);
	}

	public void Show(String title, int x, int y, int w, int h) {
		super.setLocation(x, y);
		super.setTitle(title);
		super.setSize(w, h);
	}

	public static void main(String[] args) {
		MyWindow w1 = new MyWindow();
		w1.Show("test", 550, 280, 600, 400);
		w1.Show("JFrame");
	}
}
