package DUT_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame {
	private JPanel panelButton;

	public void initFrame() {
		this.setSize(350, 400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void initComponents() {
		initFrame();

		this.setLayout(null);
		JTextArea input = new JTextArea();
		input.setBounds(5, 5, this.getWidth() - 25, 100);

		panelButton = new JPanel();
		panelButton.setBounds(0, input.getHeight() + 10, this.getWidth() -15, this.getHeight() - 150);
		panelButton.setLayout(new GridLayout(5, 4));

		JButton btnCE = new JButton("CE");
		JButton btnC = new JButton("C");
		JButton btnDelete = new JButton("Del");
		JButton btnDivide = new JButton(":");
		
		JButton btnMuilti = new JButton("X");
		JButton btnSub = new JButton("-");
		JButton btnAdd = new JButton("+");
		JButton btnEqual = new JButton("=");
		btnEqual.setBackground(Color.BLUE);
		JButton btnAddSub = new JButton("+/-");
		btnAddSub.setBackground(Color.white);
		JButton btnDot = new JButton(".");
		btnDot.setBackground(Color.white);
		JButton[] numberBtn = new JButton[10];
		for (int i = 0; i <= 9; i++) {
			numberBtn[i] = new JButton();
			numberBtn[i].setBackground(Color.white);
			numberBtn[i].setText(i + "");
		}

		// Add button
		panelButton.add(btnCE);
		panelButton.add(btnC);
		panelButton.add(btnDelete);
		panelButton.add(btnDivide);

		panelButton.add(numberBtn[7]);
		panelButton.add(numberBtn[8]);
		panelButton.add(numberBtn[9]);
		panelButton.add(btnMuilti);

		panelButton.add(numberBtn[4]);
		panelButton.add(numberBtn[5]);
		panelButton.add(numberBtn[6]);
		panelButton.add(btnSub);

		panelButton.add(numberBtn[1]);
		panelButton.add(numberBtn[2]);
		panelButton.add(numberBtn[3]);
		panelButton.add(btnAdd);

		panelButton.add(btnAddSub);
		panelButton.add(numberBtn[0]);
		panelButton.add(btnDot);
		panelButton.add(btnEqual);

		this.add(input);
		this.add(panelButton);
	}

	public Calculator() {
		initComponents();
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
