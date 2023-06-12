package test;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private Button btn;
	private JPanel container;

	public MyFrame() {
		this.setBackground(Color.cyan);
		this.setVisible(true);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		btn = new Button("Click here");
		btn.setBounds(100, 100, 200, 100);
		this.add(btn);
		btn.addActionListener((e) -> {
			// Do ActionListener chỉ có một phương thức trừu tượng bên trong class
			// nên ta có thể dùng lamda thay vì làm cách thủ công là new ActionListener
			//Nói cách khác thì ActionListener là các funtional interfaces
			JOptionPane.showMessageDialog(this, "Alo");
		});

	}
}
