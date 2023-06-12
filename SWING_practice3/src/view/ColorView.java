package view;

import model.ColorModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.colorListener;

public class ColorView extends JFrame {
	// colorScreen: ý là màu(chữ,nền) của phần label hiện ra
	//thực chất bài này ko cần dùng ColorModel
	private ColorModel colorScreen;
	private JLabel screen;

	public ColorView() {
		this.colorScreen = new ColorModel();
		this.init();
	}

	public void init() {
		this.setTitle("MY COLOR");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		// Tạo 1 label để test chức năng màu
		screen = new JLabel("TEXT", JLabel.CENTER);
		screen.setFont(new Font("Times New Roman", Font.BOLD, 30));
		screen.setBackground(Color.white);
		//Do bị lỗi ko hiện background nên setOpaque là true
		screen.setOpaque(true);
		JPanel jpanel_button = new JPanel();
		jpanel_button.setLayout(new GridLayout(2, 3, 10, 10));
		// Tạo listener
		ActionListener ac = new colorListener(this);
		
		// Tạo 3 nút bấm có màu để khi bấm thì thay đổi
		// màu chữ của label
		JButton red_text = new JButton("RED TEXT");
		red_text.setForeground(Color.red);
		red_text.setBackground(Color.white);
		red_text.addActionListener(ac);
		red_text.setFont(font);
		//Không tô viền
		red_text.setBorderPainted(false);
		
		JButton yellow_text = new JButton("YELLOW TEXT");
		yellow_text.setForeground(Color.yellow);
		yellow_text.setBackground(Color.white);
		yellow_text.addActionListener(ac);
		yellow_text.setFont(font);
		//Không tô viền
		yellow_text.setBorderPainted(false);
		
		JButton green_text = new JButton("GREEN TEXT");
		green_text.setForeground(Color.green);
		green_text.setBackground(Color.white);
		green_text.addActionListener(ac);
		green_text.setFont(font);
		//Không tô viền
		green_text.setBorderPainted(false);
		
		// Tạo 3 nút bấm có màu để khi bấm thì thay đổi
		// màu chữ của label
		JButton red_background = new JButton("RED BACKGROUND");
		red_background.setBackground(Color.red);
		red_background.addActionListener(ac);
		red_background.setFont(font);
		
		JButton yellow_background = new JButton("YELLOW BACKGROUND");
		yellow_background.setBackground(Color.yellow);
		yellow_background.addActionListener(ac);
		yellow_background.setFont(font);
		
		JButton green_background = new JButton("GREEN BACKGROUND");
		green_background.setBackground(Color.green);
		green_background.addActionListener(ac);
		green_background.setFont(font);
		
		// Add 6 nút đó vào jpanel_button
		jpanel_button.add(red_text);
		jpanel_button.add(yellow_text);
		jpanel_button.add(green_text);
		jpanel_button.add(red_background);
		jpanel_button.add(yellow_background);
		jpanel_button.add(green_background);
//		green_background.setBo

		// set layout jframe thành gridlayout 2 hàng, 1 cột
		this.setLayout(new GridLayout(2, 1, 10, 10));
		this.add(screen);
		this.add(jpanel_button);
	}
	
	public void updateColorText(Color c) {
		this.screen.setForeground(c);
	}
	public void updateColorBackGround(Color c) {
		this.screen.setBackground(c);
	}
}
