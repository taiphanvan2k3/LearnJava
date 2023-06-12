package Cau1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cau1 extends JFrame implements ActionListener {
	private JTextField txtCanhA;
	private JTextField txtCanhB;
	private JTextField txtCanhC;
	private JTextField txtKetqua;

	private void initComponents() {
		this.setLayout(new GridLayout(2, 1, 20, 20));

		JLabel lblCanhA = new JLabel("Độ dài cạnh a:");
		txtCanhA = new JTextField(30);

		JLabel lblCanhB = new JLabel("Độ dài cạnh b:");
		txtCanhB = new JTextField(30);

		JLabel lblCanhC = new JLabel("Độ dài cạnh c:");
		txtCanhC = new JTextField(30);

		JPanel pnlInput = new JPanel();
		pnlInput.setBorder(new EmptyBorder(20, 60, 20, 60));
		pnlInput.setLayout(new GridLayout(3, 2, 20, 20));
		pnlInput.add(lblCanhA);
		pnlInput.add(txtCanhA);
		pnlInput.add(lblCanhB);
		pnlInput.add(txtCanhB);
		pnlInput.add(lblCanhC);
		pnlInput.add(txtCanhC);

		JPanel pnlButton = new JPanel();
		// Set padding
		pnlButton.setBorder(new EmptyBorder(0, 60, 20, 60));
		pnlButton.setLayout(new GridLayout(3, 2, 20, 20));

		JLabel txtTmp = new JLabel("");
		JButton btnCalcArea = new JButton("Tính diện tích");
		JLabel txtTmp2 = new JLabel("");
		JButton btnCalcChuVi = new JButton("Tính chu vi");

		pnlButton.add(txtTmp);
		pnlButton.add(btnCalcArea);
		pnlButton.add(txtTmp2);
		pnlButton.add(btnCalcChuVi);

		JLabel lblKetqua = new JLabel("Kết quả:");
		txtKetqua = new JTextField(30);
		pnlButton.add(lblKetqua);
		pnlButton.add(txtKetqua);
		this.add(pnlInput);
		this.add(pnlButton);

		btnCalcArea.addActionListener(this);
		btnCalcChuVi.addActionListener(this);
	}

	public Cau1() {
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		initComponents();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Cau1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double a = -1, b = -1, c = -1;
		try {
			a = Double.valueOf(txtCanhA.getText());
			b = Double.valueOf(txtCanhB.getText());
			c = Double.valueOf(txtCanhC.getText());
			if (a <= 0 || b <= 0 || c <= 0)
				throw new Exception("Độ dài nhập vào phải lớn hơn 0.");
			else if (a + b <= c || a + c <= b || b + c <= a)
				throw new Exception("Không tạo thành tam giác.");
			String src = e.getActionCommand();
			if (src.equals("Tính chu vi")) {
				txtKetqua.setText((a + b + c) + "");
			} else if (src.equals("Tính diện tích")) {
				double p = (a + b + c) / 2;
				double tmp = p * (p - a) * (p - b) * (p - c);
				txtKetqua.setText(Math.sqrt(tmp) + "");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
			txtKetqua.setText("");
		}
	}
}
