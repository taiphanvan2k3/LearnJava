package DUT_04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BaiTap02 extends JFrame implements ActionListener {
	private JTextField txtNhapA;
	private JTextField txtNhapB;
	private JTextField txtKetQua;

	public void initComponents() {
		this.setSize(600, 300);
		this.setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tính toán");
		this.setVisible(true);
	}

	public BaiTap02() {
		this.initComponents();
		JLabel lbl = new JLabel("Minh hoạ các phép toán");
		lbl.setFont(new Font("Arial", Font.BOLD, 20));
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(3, 2, 0, 20));

		JLabel lblNhapa = new JLabel("Nhập a:");
		lblNhapa.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblNhapb = new JLabel("Nhập b:");
		lblNhapb.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblNhapkq = new JLabel("Kết quả:");
		lblNhapkq.setFont(new Font("Arial", Font.BOLD, 15));

		txtNhapA = new JTextField();
		txtNhapB = new JTextField();
		txtKetQua = new JTextField();

		pnlCenter.add(lblNhapa);
		pnlCenter.add(txtNhapA);
		pnlCenter.add(lblNhapb);
		pnlCenter.add(txtNhapB);
		pnlCenter.add(lblNhapkq);
		pnlCenter.add(txtKetQua);

		JPanel pnlButton = new JPanel();
		JPanel pnlPhepTinh = new JPanel();

		pnlPhepTinh.setLayout(new FlowLayout());
		JButton btnCong = new JButton("Cộng");
		JButton btnTru = new JButton("Trừ");
		JButton btnNhan = new JButton("Nhân");
		JButton btnChia = new JButton("Chia");

		pnlPhepTinh.add(btnCong);
		pnlPhepTinh.add(btnTru);
		pnlPhepTinh.add(btnNhan);
		pnlPhepTinh.add(btnChia);

		JPanel pnlThaoTac = new JPanel();
		JButton btnExit = new JButton("Exit");
		JButton btnReset = new JButton("Reset");

		pnlThaoTac.setLayout(new FlowLayout());
		pnlThaoTac.add(btnExit);
		pnlThaoTac.add(btnReset);

		this.add(lbl, BorderLayout.NORTH);

		pnlButton.setLayout(new BorderLayout());
		pnlButton.add(pnlPhepTinh, BorderLayout.NORTH);
		pnlButton.add(pnlThaoTac, BorderLayout.CENTER);

		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlButton, BorderLayout.SOUTH);
		
		btnCong.addActionListener(this);
		btnTru.addActionListener(this);
		btnNhan.addActionListener(this);
		btnChia.addActionListener(this);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exitJFrame();
			}
		});

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNhapA.setText("");
				txtNhapB.setText("");
				txtKetQua.setText("");
			}
		});
	}

	public void exitJFrame() {
		this.dispose();
	}

	public static void main(String[] args) {
		new BaiTap02();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Cộng") || src.equals("Trừ") || src.equals("Nhân") || src.equals("Chia")) {
			txtKetQua.setText("");
			double x = 0, y = 0;
			boolean check = true;
			try {
				x = Double.valueOf(txtNhapA.getText());
				txtNhapA.setBackground(Color.white);
			} catch (Exception e2) {
				txtNhapA.setBackground(Color.red);
				check = false;
			}

			try {
				y = Double.valueOf(txtNhapB.getText());
				txtNhapB.setBackground(Color.white);

			} catch (Exception e2) {
				txtNhapB.setBackground(Color.red);
				check = false;
			}
			if (check) {
				if (src.equals("Cộng"))
					txtKetQua.setText((x + y) + "");
				else if (src.endsWith("Trừ"))
					txtKetQua.setText((x - y) + "");
				else if (src.equals("Nhân"))
					txtKetQua.setText((x * y) + "");
				else {
					if (y == 0)
						JOptionPane.showMessageDialog(txtKetQua, "Chia cho 0");
					else
						txtKetQua.setText((x / y) + "");
				}

			}
		}
	}
}
