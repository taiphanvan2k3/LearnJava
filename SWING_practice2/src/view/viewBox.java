package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.controllBox;
import model.LastButton;

public class viewBox extends JFrame {
	private LastButton lastButton;
	private JLabel show_button;

	public viewBox() {
		this.lastButton = new LastButton();
		this.init();
	}

	public void init() {
		this.setTitle("Last Button");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		// Tạo lable để mỗi lần nhấn nút là hiển thị
		show_button = new JLabel("Bạn chưa thực hiện bấm nút nào");
		show_button.setFont(new Font("Times New Roman", Font.BOLD, 20));

		// Tạo ra đối tượng thuộc lớp ActionListerner để xử lí sự kiện
		ActionListener ac = new controllBox(this);

		JLabel title = new JLabel("Menu Box", JLabel.CENTER);

		// Tạo font chữ, cỡ chữ
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));

		// label panel_button chứ 4 nút theo GridLayout 2 hàng, 2 cột
		JPanel panel_Button = new JPanel();
		panel_Button.setLayout(new GridLayout(2, 2, 10, 10));

		JButton list_button[] = new JButton[5];
		for (int i = 1; i <= 4; i++) {
			list_button[i] = new JButton(i + "");
			list_button[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_Button.add(list_button[i]);
			// add sự kiện cho từng button
			list_button[i].addActionListener(ac);
		}

		this.setLayout(new BorderLayout());
		this.add(panel_Button, BorderLayout.CENTER);
		this.add(show_button, BorderLayout.SOUTH);
		this.add(title, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void updateLabel(int val) {
		this.lastButton.setValue(val);
		this.show_button.setText("Bạn vừa nhấn " + val);
	}
}
