package Test;

import javax.swing.UIManager;

import view.viewBox;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new viewBox();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
