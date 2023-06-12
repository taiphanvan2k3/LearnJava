package helper;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class Validator {
	public static boolean checkEmpty(JTextField jtext, StringBuilder sb, String message) {
		if (jtext.getText().equals("")) {
			jtext.setBackground(Color.red);
			sb.append(message).append("\n");
			return true;
		}

		jtext.setBackground(Color.white);
		return false;
	}

	public static boolean checkAge(JTextField jtext, StringBuilder sb) {
		if (checkEmpty(jtext, sb, "Tuổi chưa được nhập"))
			return false;
		try {
			int age = Integer.valueOf(jtext.getText());
			if (age < 18 || age > 55) {
				jtext.setBackground(Color.red);
				sb.append("Tuổi không hợp lệ (nằm ngoài khoảng 18-55).\n");
				return false;
			}
		} catch (Exception e) {
			jtext.setBackground(Color.red);
			sb.append("Giá trị tuổi không hợp lệ,phải là giá trị số nguyên.\n");
			return false;
		}
		jtext.setBackground(Color.white);
		return true;
	}

	public static boolean checkSalary(JTextField jtext, StringBuilder sb) {
		if (checkEmpty(jtext, sb, "Lương chưa được nhập"))
			return false;
		try {
			Double age = Double.valueOf(jtext.getText());
			if (age < 5000000) {
				jtext.setBackground(Color.red);
				sb.append("Lương không hợp lệ (lương phải lớn hơn 5,000,000).\n");
				return false;
			}
		} catch (Exception e) {
			jtext.setBackground(Color.red);
			sb.append("Giá trị lương không hợp lệ,phải là giá trị số.\n");
			return false;
		}
		jtext.setBackground(Color.white);
		return true;
	}

	public static boolean checkEmail(JTextField jtext, StringBuilder sb) {
		if (checkEmpty(jtext, sb, "Email chưa được nhập"))
			return false;
		/*
		 \w: kí tự viết tắt của [a-zA-Z0-9]
		 \w+:một hoặc nhiều kí tự dạng trên
		 */
		Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(jtext.getText());
		if (!matcher.find()) {
			jtext.setBackground(Color.red);
			sb.append("Email không hợp lệ.\n");
			return false;
		}
		jtext.setBackground(Color.white);
		return true;
	}
}
