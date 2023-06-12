package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MyComputer extends JFrame {
	public MyComputer() {
		this.setTitle("My Calculator");
		this.setLocationRelativeTo(null);
		this.setSize(250, 350);
		JTextField jTextField = new JTextField();
		JPanel panel_head=new JPanel();
		panel_head.setLayout(new BorderLayout());
		panel_head.add(jTextField,BorderLayout.CENTER);
		JPanel panel_button= new JPanel();
		panel_button.setLayout(new GridLayout(5,3,5,5));
		JButton button_num []= new JButton[10];
		for(int i=0;i<=9;i++)
			button_num[i]=new JButton(i+"");
		JButton button_add=new JButton("+");
		JButton button_sub=new JButton("-");
		JButton button_multi=new JButton("*");
		JButton button_div=new JButton("/");
		JButton button_equal=new JButton("=");
		for(int i=0;i<=9;i++)
			panel_button.add(button_num[i]);
		panel_button.add(button_add);
		panel_button.add(button_sub);
		panel_button.add(button_multi);
		panel_button.add(button_div);
		panel_button.add(button_equal);
		this.setLayout(new BorderLayout(10,5));
		this.add(panel_head,BorderLayout.NORTH);
		this.add(panel_button,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MyComputer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
