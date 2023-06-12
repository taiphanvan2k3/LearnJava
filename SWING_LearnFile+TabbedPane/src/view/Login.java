package view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	public Login() {
		this.setLayout(new GridLayout(3,1));
		JLabel label_userName=new JLabel("User name:");
		JLabel label_password= new JLabel("Password:");
		JTextField jTextField_userName=new JTextField();
		JPasswordField jPasswordField= new JPasswordField();
		JLabel label_thongBao= new JLabel();
		JButton button_login= new JButton("Login");
		this.add(label_userName);
		this.add(jTextField_userName);
		this.add(label_password);
		this.add(jPasswordField);
		this.add(label_thongBao);
		this.add(button_login);
	}
}
