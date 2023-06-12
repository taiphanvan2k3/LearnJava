package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.controllCalculator;
import model.modelCalculator;

public class viewCalculator extends JFrame {
	private modelCalculator modelCal;
	private JTextField textField_ans;
	private JTextField textField_val1;
	private JTextField textField_val2;

	public viewCalculator() {
		this.modelCal = new modelCalculator();
		this.init();
	}

	public void init() {
		this.setTitle("Mini calculator");
		this.setLocation(500, 200);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial", Font.BOLD, 20);

		JLabel label_val1 = new JLabel("First value", JLabel.CENTER);
		textField_val1 = new JTextField(50);
		textField_val1.setFont(font);
		label_val1.setFont(font);

		JLabel label_val2 = new JLabel("Second value", JLabel.CENTER);
		textField_val2 = new JTextField(50);
		label_val2.setFont(font);
		textField_val2.setFont(font);

		JLabel label_ans = new JLabel("Answer", JLabel.CENTER);
		textField_ans = new JTextField(50);
		label_ans.setFont(font);
		textField_ans.setFont(font);

		JPanel ioView = new JPanel();
		ioView.setLayout(new GridLayout(3, 2, 10, 10));

		ioView.add(label_val1);
		ioView.add(textField_val1);
		ioView.add(label_val2);
		ioView.add(textField_val2);
		ioView.add(label_ans);
		ioView.add(textField_ans);

		// Tạo các nút bấm
		JButton button_add = new JButton("+");
		button_add.setFont(font);
		JButton button_minus = new JButton("-");
		button_minus.setFont(font);
		JButton button_multiply = new JButton("*");
		button_multiply.setFont(font);
		JButton button_divide = new JButton("/");
		button_divide.setFont(font);
		JButton button_mod = new JButton("%");
		button_mod.setFont(font);
		JButton button_power = new JButton("^");
		button_power.setFont(font);

		JPanel panel_button = new JPanel();
		panel_button.setLayout(new GridLayout(2, 3, 5, 5));
		panel_button.add(button_add);
		panel_button.add(button_minus);
		panel_button.add(button_multiply);
		panel_button.add(button_divide);
		panel_button.add(button_power);
		panel_button.add(button_mod);

		// Ép sự kiện từng button
		ActionListener ac = new controllCalculator(this);
		button_add.addActionListener(ac);
		button_minus.addActionListener(ac);
		button_multiply.addActionListener(ac);
		button_divide.addActionListener(ac);
		button_mod.addActionListener(ac);
		button_power.addActionListener(ac);
		this.setLayout(new BorderLayout());
		this.add(ioView, BorderLayout.CENTER);
		this.add(panel_button, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public void setVal() {
		double firstVal = Double.valueOf(textField_val1.getText());
		double secondVal = Double.valueOf(textField_val2.getText());
		this.modelCal.setFirstValue(firstVal);
		this.modelCal.setSecondValue(secondVal);
	}

	public void add() {
		this.setVal();
		this.modelCal.add();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}

	public void minus() {
		this.setVal();
		this.modelCal.minus();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}

	public void multiply() {
		this.setVal();
		this.modelCal.multiply();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}

	public void divide() {
		this.setVal();
		this.modelCal.divide();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}

	public void mod() {
		this.setVal();
		this.modelCal.mod();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}

	public void power() {
		this.setVal();
		this.modelCal.power();
		textField_ans.setText(this.modelCal.getAnswer() + "");
	}
}
