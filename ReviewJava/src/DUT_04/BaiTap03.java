package DUT_04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BaiTap03 extends JFrame implements ActionListener {
	private JButton[] btnNumbers = new JButton[10];
	private JTextArea txtInput;

	private void initComponents() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 500);
		this.setTitle("Calculator");
		this.setLocationRelativeTo(null);
		// panel input

		txtInput = new JTextArea();
		txtInput.setRows(2);
		txtInput.setEditable(false);
		JScrollPane jScrollPane = new JScrollPane(txtInput);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		txtInput.setText("\n0");

		txtInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtInput.setFont(new Font("Arial", Font.BOLD, 30));
		txtInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		txtInput.setAutoscrolls(true);
		// panelInput.add(txtInput);

		// panel button
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(5, 4, 3, 3));
		JButton btnCE = new JButton("CE");
		JButton btnC = new JButton("C");
		JButton btnDel = new JButton("<─");
		JButton btnDivide = new JButton(":");
		JButton btnMulitply = new JButton("x");
		JButton btnSub = new JButton("-");
		JButton btnAdd = new JButton("+");
		JButton btnAddSub = new JButton("+/-");
		JButton btnDot = new JButton(".");
		JButton btnRes = new JButton("=");
		panelButton.add(btnCE);
		panelButton.add(btnC);
		panelButton.add(btnDel);
		panelButton.add(btnDivide);

		// Khởi tạo giá trị cho các button số
		for (int i = 0; i <= 9; i++) {
			btnNumbers[i] = new JButton(i + "");
			btnNumbers[i].addActionListener(this);
		}

		panelButton.add(btnNumbers[7]);
		panelButton.add(btnNumbers[8]);
		panelButton.add(btnNumbers[9]);
		panelButton.add(btnMulitply);

		panelButton.add(btnNumbers[4]);
		panelButton.add(btnNumbers[5]);
		panelButton.add(btnNumbers[6]);
		panelButton.add(btnSub);

		panelButton.add(btnNumbers[1]);
		panelButton.add(btnNumbers[2]);
		panelButton.add(btnNumbers[3]);
		panelButton.add(btnAdd);

		panelButton.add(btnAddSub);
		panelButton.add(btnNumbers[0]);
		panelButton.add(btnDot);
		panelButton.add(btnRes);

		this.setLayout(new BorderLayout());
		this.add(jScrollPane, BorderLayout.NORTH);
		this.add(panelButton, BorderLayout.CENTER);

		// Thêm event
		btnC.addActionListener(this);
		btnCE.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMulitply.addActionListener(this);
		btnDivide.addActionListener(this);
		btnDel.addActionListener(this);
		btnRes.addActionListener(this);
		btnDot.addActionListener(this);
		this.setVisible(true);
	}

	public BaiTap03() {
		initComponents();
	}

	public static void main(String[] args) {
		new BaiTap03();
	}

	private double tinhToan(String chuoiPhepTinh) {
		String[] ds = chuoiPhepTinh.split(" ");
		Stack<Character> phepTinh = new Stack<>();
		Stack<Double> num = new Stack<>();

		for (int i = 0; i < ds.length; i++) {
			char c = ds[i].charAt(0);
			if (Character.isDigit(c)) {
				if (!phepTinh.isEmpty() && (phepTinh.peek() == 'x' || phepTinh.peek() == ':')) {
					double prev = num.pop();
					double cur = Double.valueOf(ds[i]);
					char temp = phepTinh.pop();
					if (temp == 'x')
						num.push(prev * cur);
					else
						num.push(prev / cur);
				} else
					num.push(Double.valueOf(ds[i]));
			} else {
				phepTinh.push(c);
			}
		}

		double res = num.get(0);
		for (int i = 0; i < phepTinh.size(); i++) {
			char c = phepTinh.get(i);
			if (c == '+')
				res += num.get(i + 1);
			else
				res -= num.get(i + 1);
		}
		return res;
	}

	private StringBuilder chuoiPhepTinh = new StringBuilder();
	private String chuoiPhepTinhTemp = "";

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String[] ds = txtInput.getText().split("\n");
		if (Character.isDigit(src.charAt(0)) || src.equals(".")) {
			chuoiPhepTinhTemp += src;
			if (ds[1].equals("0"))
				txtInput.setText(chuoiPhepTinh + "\n" + src);
			else
				txtInput.setText(chuoiPhepTinh + "\n" + ds[1] + src);
		} else if (src.equals("CE")) {
			txtInput.setText(chuoiPhepTinh + "\n0");
		} else if (src.equals("<─")) {
			if (ds[1].length() == 1)
				txtInput.setText(chuoiPhepTinh + "\n0");
			else {
				txtInput.setText(chuoiPhepTinh + "\n" + ds[1].substring(0, ds[1].length() - 1));
			}
		} else if (src.equals("C")) {
			chuoiPhepTinhTemp = "";
			chuoiPhepTinh.setLength(0);
			txtInput.setText("\n0");
		} else if (src.equals("=")) {
			if (ds[0].length() > 0) {
				Double res = tinhToan(ds[0] + " " + ds[1]);
				txtInput.setText("\n" + res);
			}
		} else {
			if (chuoiPhepTinhTemp != "") {
				if (chuoiPhepTinh.isEmpty())
					chuoiPhepTinh.append(chuoiPhepTinhTemp);
				else
					chuoiPhepTinh.append(" " + chuoiPhepTinhTemp);
			} else
				chuoiPhepTinh.append(chuoiPhepTinhTemp);
			String phepToan = "+-x:";
			if (phepToan.indexOf(chuoiPhepTinh.charAt(chuoiPhepTinh.length() - 1)) != -1)
				chuoiPhepTinh.setCharAt(chuoiPhepTinh.length() - 1, src.charAt(0));
			else
				chuoiPhepTinh.append(" " + src);
			chuoiPhepTinhTemp = "";
			txtInput.setText(chuoiPhepTinh + "\n" + "0");
		}
	}
}
