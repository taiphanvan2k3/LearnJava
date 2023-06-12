package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Threading.ThreadCheckTkMk;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class signUpForm extends JFrame {

	private JPanel contentPane;
	private static JLabel lblCheckConfirmWritten;
	private static JTextField txtTaiKhoan;
	private static JPasswordField txtMatkhau;
	private static JPasswordField txtXacNhan;
	private static JLabel lblCheckTkWriten;
	private static JLabel lblCheckMkWriten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new signUpForm();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void initJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 376);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
	}

	public signUpForm() {
		initJFrame();
		initComponents();
	}

	public void initComponents() {
		JLabel lblTitle = new JLabel("Đăng kí tài khoản");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(209, 10, 209, 34);
		contentPane.add(lblTitle);

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTaiKhoan.setBounds(50, 83, 88, 24);
		contentPane.add(lblTaiKhoan);

		JLabel lblNewLabel_2 = new JLabel("Mật khẩu:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(50, 147, 88, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Xác nhận mật khẩu");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(52, 224, 147, 24);
		contentPane.add(lblNewLabel_3);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTaiKhoan.setToolTipText("Email hoặc số điện thoại");
		txtTaiKhoan.setBounds(209, 80, 291, 34);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		txtMatkhau = new JPasswordField();
		txtMatkhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatkhau.setBounds(209, 139, 291, 34);
		contentPane.add(txtMatkhau);

		txtXacNhan = new JPasswordField();
		txtXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtXacNhan.setBounds(209, 219, 291, 34);
		contentPane.add(txtXacNhan);

		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangKy.setBounds(184, 298, 111, 32);
		contentPane.add(btnDangKy);

		JButton btnCancel = new JButton("Huỷ");

		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCancel.setBounds(338, 300, 111, 29);
		contentPane.add(btnCancel);

		JSeparator separator = new JSeparator();
		separator.setBounds(28, 54, 545, 1);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 276, 548, 14);
		contentPane.add(separator_1);

		JCheckBox checkShowPassword = new JCheckBox("");
		checkShowPassword.setToolTipText("");
		checkShowPassword.setBounds(209, 179, 21, 28);
		contentPane.add(checkShowPassword);

		JLabel lblHienThiMatKhau = new JLabel("Hiển thị mật khẩu");
		lblHienThiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHienThiMatKhau.setBounds(236, 179, 136, 30);
		contentPane.add(lblHienThiMatKhau);

		lblCheckTkWriten = new JLabel("");
		lblCheckTkWriten.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckTkWriten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheckTkWriten.setBounds(510, 90, 21, 24);
		contentPane.add(lblCheckTkWriten);

		lblCheckMkWriten = new JLabel("");
		lblCheckMkWriten.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckMkWriten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheckMkWriten.setBounds(510, 147, 21, 24);
		contentPane.add(lblCheckMkWriten);

		lblCheckConfirmWritten = new JLabel("");
		lblCheckConfirmWritten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheckConfirmWritten.setBounds(510, 224, 21, 24);
		contentPane.add(lblCheckConfirmWritten);

		// Add action listener
		checkShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMatkhau.setEchoChar(
						checkShowPassword.isSelected() ? 0 : (char) UIManager.get("PasswordField.echoChar"));
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValidData();
			}
		});
		
		ThreadCheckTkMk t = new ThreadCheckTkMk(txtTaiKhoan, txtMatkhau, txtXacNhan, lblCheckTkWriten,
				lblCheckMkWriten, lblCheckConfirmWritten);
		t.start();
	}
	
	private void checkValidData() {
		StringBuilder sb = new StringBuilder();
		if (txtTaiKhoan.getText().equals("")) {
			sb.append("Tài khoản đang trống.\n");
			txtTaiKhoan.setBackground(Color.red);
		} else
			txtTaiKhoan.setBackground(Color.white);

		String pass = new String(txtMatkhau.getPassword());
		if (pass.equals("")) {
			sb.append("Mật khẩu đang trống.\n");
			txtMatkhau.setBackground(Color.red);
		} else
			txtMatkhau.setBackground(Color.white);
		
		String passConfirm = new String(txtXacNhan.getPassword());
		if (passConfirm.equals("")) {
			sb.append("Mật khẩu xác nhận đang trống.");
			txtXacNhan.setBackground(Color.red);
		} else
			txtXacNhan.setBackground(Color.white);

		if (sb.length() > 0)
			JOptionPane.showMessageDialog(contentPane, sb, "Error:", JOptionPane.INFORMATION_MESSAGE);
		else {
			if (!pass.equals(passConfirm)) {
				JOptionPane.showMessageDialog(contentPane, "Mật khẩu xác nhận không khớp.");
				txtXacNhan.setBackground(Color.red);
			} else {
				txtXacNhan.setBackground(Color.white);
				JOptionPane.showMessageDialog(contentPane, "Đăng kí tài khoản thành công.");
			}
		}
	}
}
