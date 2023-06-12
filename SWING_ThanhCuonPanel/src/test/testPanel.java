package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class testPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testPanel frame = new testPanel();
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
	public testPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		this.setBounds(100,100,1000,700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1000, 900));
		contentPane.setBorder(BorderFactory.createLineBorder(Color.cyan));
		JScrollPane scroll = new JScrollPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang sinh viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(233, 48, 412, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(96, 598, 85, 21);
		contentPane.add(btnNewButton);
		JButton btnNewButton1 = new JButton("New button");
		JButton btnNewButton2 = new JButton("New button");
		btnNewButton1.setBounds(96, 700, 85, 21);
		btnNewButton2.setBounds(96, 800, 85, 21);
		contentPane.add(btnNewButton1);
		contentPane.add(btnNewButton2);
		getContentPane().add(scroll);
	}
}
