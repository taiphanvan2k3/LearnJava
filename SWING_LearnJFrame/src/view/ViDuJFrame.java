package view;

import javax.swing.JFrame;

public class ViDuJFrame {
	public static void main(String[] args) {
		JFrame jf= new JFrame();
		//Cho phép hiển thị
		jf.setVisible(true);
		//set gốc toạ độ tại toạ độ (x,y)
		jf.setLocation(500, 280);
		jf.setSize(600, 400);
		jf.setTitle("Ví dụ về JFrame");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
