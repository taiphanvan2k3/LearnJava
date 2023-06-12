package Lab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class CountDown extends JFrame {

	private JPanel Background;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Minutes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountDown frame = new CountDown();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CountDown() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\OneDrive - The University of Technology\\Ít dùng đến\\Pictures\\Saved Pictures\\ảnh1.png"));
		setTitle("Count Down");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 374);
		Background = new JPanel();
		Background.setBackground(Color.DARK_GRAY);
		Background.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Background);
		Background.setLayout(null);
		
		JPanel Display = new JPanel();
		Display.setBackground(Color.BLACK);
		Display.setBounds(304, 68, 293, 137);
		Background.add(Display);
		
		JButton btnStart = new JButton("Start");
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnStart.setBackground(Color.LIGHT_GRAY);
		btnStart.setBounds(306, 234, 163, 44);
		Background.add(btnStart);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnReset.setBackground(new Color(255, 51, 51));
		btnReset.setBounds(479, 234, 118, 44);
		Background.add(btnReset);
		
		textField = new JTextField();
		textField.setBounds(35, 101, 96, 19);
		Background.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(34, 205, 53, 19);
		Background.add(textField_1);
		textField_1.setColumns(10);
		
		Minutes = new JTextField();
		Minutes.setBounds(112, 205, 53, 19);
		Background.add(Minutes);
		Minutes.setColumns(10);
		
		JLabel label1 = new JLabel("Enter event date YYYY-MM-DD 00:00");
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label1.setForeground(Color.WHITE);
		label1.setBounds(33, 61, 261, 30);
		Background.add(label1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 234, 131, 44);
		Background.add(btnNewButton);
		
		JLabel labelEnter = new JLabel("Enter time:");
		labelEnter.setForeground(Color.WHITE);
		labelEnter.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelEnter.setBounds(35, 158, 100, 13);
		Background.add(labelEnter);
		
		JLabel labelHours = new JLabel("Hours");
		labelHours.setForeground(Color.WHITE);
		labelHours.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelHours.setBounds(35, 182, 45, 13);
		Background.add(labelHours);
		
		JLabel labelMinutes = new JLabel("Minutes");
		labelMinutes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelMinutes.setForeground(Color.WHITE);
		labelMinutes.setBounds(112, 181, 53, 13);
		Background.add(labelMinutes);
	}
}
