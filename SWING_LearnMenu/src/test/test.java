package test;

import javax.swing.UIManager;

import view.MenuExample;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MenuExample();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
