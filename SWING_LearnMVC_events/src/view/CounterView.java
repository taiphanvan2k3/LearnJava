package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame {
	private CounterModel counterModel;
	private JButton button_up, button_down;
	private JLabel label;

	public void init() {
		this.setTitle("Counter");
		this.setLocationRelativeTo(null);
		this.setSize(250, 250);

		ActionListener ac = new CounterListener(this);

		button_up = new JButton("Up");
		button_up.addActionListener(ac);
		button_up.setFont(new Font("Consolas",Font.BOLD,20));
		
		button_down = new JButton("Down");
		button_down.addActionListener(ac);
		button_down.setFont(new Font("Consolas",Font.BOLD|Font.ITALIC,20));
		
		label = new JLabel(this.counterModel.getValue() + "", JLabel.CENTER);
		label.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(button_up, BorderLayout.WEST);
		panel.add(label, BorderLayout.CENTER);
		panel.add(button_down, BorderLayout.EAST);
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public CounterView() {
		counterModel = new CounterModel();
		this.init();
		this.setVisible(true);
	}

	public CounterModel getCounterModel() {
		return counterModel;
	}

	public void increase() {
		this.counterModel.upValue();
		this.label.setText(this.counterModel.getValue()+"");
	}

	public void decrease() {
		this.counterModel.downValue();
		this.label.setText(this.counterModel.getValue()+"");
	}
}
