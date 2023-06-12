package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.controllerTool;
import model.modelTool;

public class viewTool extends JFrame {
	private modelTool ModelTool;
	private JTextArea jtextArea_input;
	private JTextField jtextField_keyword;
	private JLabel ans;

	public void init() {
		this.setSize(500, 400);
		this.setLocation(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public viewTool() {
		this.ModelTool = new modelTool();
		this.init();
		Font font = new Font("Arial", Font.BOLD, 15);
		JLabel jlabel_text = new JLabel("Văn bản");
		jlabel_text.setFont(font);
		jtextArea_input = new JTextArea();
		jtextArea_input.setFont(font);

		//Tạo thanh cuộn cho jtextArea
		JScrollPane jScrollPane= new JScrollPane(jtextArea_input);
		
		JPanel jpanel_input = new JPanel();
		jpanel_input.setLayout(new BorderLayout());
		jpanel_input.add(jlabel_text, BorderLayout.NORTH);
		jpanel_input.add(jScrollPane, BorderLayout.CENTER);

		// panel2 chứa label từ khoá và textfield
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1, 10, 10));
		JLabel jlabel_keyword = new JLabel("Từ khoá");
		jlabel_keyword.setFont(font);
		jtextField_keyword = new JTextField();
		jtextField_keyword.setFont(font);
		panel2.add(jlabel_keyword);
		panel2.add(jtextField_keyword);

		JButton button_thongke = new JButton("Thống kế");
		button_thongke.setBackground(Color.black);
		button_thongke.setForeground(Color.white);
		button_thongke.setFont(font);
		ans = new JLabel();
		ans.setFont(font);
		ans.setBackground(Color.blue);
		ans.setForeground(Color.white);
		ans.setText("Kết quả:");
		ans.setOpaque(true);

		JPanel jpanel_thong_ke = new JPanel();
		jpanel_thong_ke.setLayout(new GridLayout(1, 2, 10, 10));
		jpanel_thong_ke.add(button_thongke);
		jpanel_thong_ke.add(ans);

		// Tạo một Panel mới kết hợp panel2 và jpanel_thog_ke lại
		JPanel jPanel_combine = new JPanel();
		jPanel_combine.setLayout(new GridLayout(2, 1, 10, 10));
		jPanel_combine.add(panel2);
		jPanel_combine.add(jpanel_thong_ke);

		// Ép sự kiện cho nút bấm thống kê
		ActionListener ac = new controllerTool(this);
		button_thongke.addActionListener(ac);

		this.setLayout(new BorderLayout(10, 10));
		this.add(jpanel_input, BorderLayout.CENTER);
		this.add(jPanel_combine, BorderLayout.SOUTH);
	}

	public void updateAnswer() {
		this.ModelTool.setVanBan(jtextArea_input.getText());
		this.ModelTool.setTuKhoa(jtextField_keyword.getText());
		this.ModelTool.thongKe();
		this.ans.setText(this.ModelTool.getKetQua());
	}

}
