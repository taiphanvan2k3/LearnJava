package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MyNotepadController;
import model.MyNotepadModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;

public class MyNotePadView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	public JLabel jLabel;
	public JTextArea jTextArea;
	public MyNotepadModel myNotepadModel;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textField;
	private JPasswordField passwordField;

	public MyNotePadView() {
		this.myNotepadModel = new MyNotepadModel();
		this.setVisible(true);
		ActionListener ac = new MyNotepadController(this);
		setBackground(new Color(255, 255, 255));
		setTitle("My Notepad");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\BtJava\\SWING_LearnIcon\\screen.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 770, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//panel này chứa thông báo và 2 button
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 50)); 
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);

		jLabel = new JLabel("Thông báo");
		jLabel.setBounds(33, 7, 370, 34);
		jLabel.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(jLabel);

		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(578, 7, 75, 31);
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOpen.addActionListener(ac);
		panel.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(663, 9, 69, 29);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSave.addActionListener(ac);
		panel.add(btnSave);

		jTextArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(jTextArea);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		jTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JTabbedPane tabs= new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		Login login = new Login();
		tabs.add("Login",login);
		login.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBackground(Color.cyan);
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUserName.setBounds(110, 81, 111, 38);
		login.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(110, 157, 95, 30);
		login.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(351, 84, 318, 38);
		textField.setFont(new Font("Arial",Font.PLAIN,20));
		login.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(351, 154, 318, 38);
		passwordField.setFont(new Font("Arial",Font.PLAIN,20));
		login.add(passwordField);
		
		JLabel label_thongbao = new JLabel("");
		label_thongbao.setBounds(110, 284, 200, 28);
		login.add(label_thongbao);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_thongbao.setText("Hello");
			}
		});
		btnNewButton.setBounds(544, 268, 125, 38);
		login.add(btnNewButton);
		 
		
		tabs.add("Courses", new courses());
		//setFont cho tiêu đề mỗi tab
		tabs.setFont(new Font("Arial",Font.BOLD,15));
		tabs.add("Select Courses",new selectCourses());
		getContentPane().add(tabs);
	}

	public void updateJLabel(String src) {
		this.jLabel.setText(src);
	}

	public void updateJTextArea(String src) {
		this.jTextArea.setText(src);
	}
}
