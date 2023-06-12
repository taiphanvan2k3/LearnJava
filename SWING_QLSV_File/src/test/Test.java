package test;

import javax.swing.UIManager;

import view.viewQuanLy;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new viewQuanLy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
