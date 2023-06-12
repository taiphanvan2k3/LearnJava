package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;

public class AppView extends JFrame {

	private JPanel jFrame;
	private JTextField textField;
	public AppView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\BtJava\\SWING_LearnIcon\\screen.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 447);
		jFrame = new JPanel();
		jFrame.setBackground(Color.PINK);
		jFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setVisible(true);
		setContentPane(jFrame);
		
		//layout là absoulute layout do đó phần setBound cho các component trước
		//khi add chúng vào jFrame
		jFrame.setLayout(null);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(84, 306, 422, 76);
		jFrame.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("HELLO WORLD");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 39, 345, 84);
		jFrame.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.cyan);
		textField.setBounds(115, 176, 370, 76);
		jFrame.add(textField);
		textField.setColumns(10);
	}
}
