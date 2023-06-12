package helper;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataValidator {
	public static void validateEmpty(JTextField txt, StringBuilder sb, String message) {
		if (txt.getText().equals("")) {
			sb.append(message + "\n");
			txt.setBackground(Color.red);
			txt.requestFocus();
		} else
			txt.setBackground(Color.white);
	}
	
	public static void validateEmpty(JPasswordField txt, StringBuilder sb, String message) {
		String pass=new String(txt.getPassword());
		if (pass.equals("")) {
			sb.append(message).append("\n");
			txt.setBackground(Color.red);
			//txt.requestFocus();
		} else
			txt.setBackground(Color.white);
	}
}
