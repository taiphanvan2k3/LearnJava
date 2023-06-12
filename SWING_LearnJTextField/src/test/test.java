package test;

import javax.swing.UIManager;

import view.viewCalculator;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		new viewCalculator();
	}
}
