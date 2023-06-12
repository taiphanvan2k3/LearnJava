package deThayHa_2023;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener {
	private JTextField txtInput;
	private JTextArea textArea;
	private JComboBox<String> cbb;
	private JButton btnSplit;
	private JButton btnXoa;

	private void init() {
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBorder(new EmptyBorder(10, 10, 30, 10));
		pnlLeft.setLayout(new GridLayout(3, 1, 20, 20));
		pnlLeft.setBorder(new EmptyBorder(10, 10, 10, 10));

		pnlLeft.add(new JLabel("Nhập số tự nhiên n"));
		pnlLeft.add(new JLabel("Tách theo chiều"));
		pnlLeft.add(new JLabel("Kết quả tách được"));

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(20, 10, 30, 10));
		pnlCenter.setLayout(new GridLayout(3, 1, 20, 20));

		JPanel pnlCenter1 = new JPanel();
		pnlCenter1.setBorder(new EmptyBorder(20, 10, 20, 10));
		pnlCenter1.setLayout(new GridLayout(1, 2));
		txtInput = new JTextField();
		txtInput.setHorizontalAlignment(JTextField.RIGHT);
		
		btnXoa = new JButton("Xoá");
		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new BorderLayout());
		pnlButton.add(btnXoa);
		pnlButton.setBorder(new EmptyBorder(0, 50, 0, 0));
		pnlCenter1.add(txtInput);
		pnlCenter1.add(pnlButton);

		JPanel pnlCenter2 = new JPanel();
		pnlCenter2.setBorder(new EmptyBorder(20, 10, 10, 10));
		pnlCenter2.setLayout(new GridLayout(1, 2));
		String[] ds = new String[] { "Từ trái sang phải", "Từ phải sang trái" };
		cbb = new JComboBox<String>(ds);
		btnSplit = new JButton("Tách số");
		JPanel pnlButtonSplit = new JPanel();
		pnlButtonSplit.setLayout(new BorderLayout());
		pnlButtonSplit.add(btnSplit);
		pnlButtonSplit.setBorder(new EmptyBorder(0, 50, 0, 0));
		pnlCenter2.add(cbb);
		pnlCenter2.add(pnlButtonSplit);

		JPanel pnlCenter3 = new JPanel();
		pnlCenter3.setBorder(new EmptyBorder(10, 10, 0, 10));
		pnlCenter3.setLayout(new GridLayout(1, 2));
		textArea = new JTextArea();
		pnlCenter3.add(textArea);
		pnlCenter.add(pnlCenter1);
		pnlCenter.add(pnlCenter2);
		pnlCenter.add(pnlCenter3);

		this.setLayout(new BorderLayout(10, 10));
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);

		btnXoa.addActionListener(this);
		btnSplit.addActionListener(this);
	}

	public GUI() {
		init();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

	private void TachSo() {
		String input = txtInput.getText().trim();
		if (!input.matches("-*\\d+")) {
			JOptionPane.showMessageDialog(this, "Số tự nhiên không hợp lệ");
			return;
		}
		StringBuilder sb = new StringBuilder(input);
		if (cbb.getSelectedIndex() == 1)
			sb.reverse();
		String res = "";
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '-')
				continue;
			if (!res.isEmpty())
				res += " ";
			res += sb.charAt(i);
		}
		textArea.setText(res);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Xoá")) {
			txtInput.setText("");
			textArea.setText("");
		} else {
			TachSo();
		}
	}
}
