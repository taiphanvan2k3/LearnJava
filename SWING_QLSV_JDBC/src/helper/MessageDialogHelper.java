package helper;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageDialogHelper {
	public static void showMessageDialog(Component com, String content, String title) {
		JOptionPane.showMessageDialog(com, content, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErrorDialog(Component com, String content, String title) {
		JOptionPane.showMessageDialog(com, content, title, JOptionPane.ERROR_MESSAGE);
	}

	public static int showConfirmDialog(Component com, String content, String title) {
		return JOptionPane.showConfirmDialog(com, content, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

	}
}
