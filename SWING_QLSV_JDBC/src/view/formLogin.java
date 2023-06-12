package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NguoiDungDAO;
import helper.DataValidator;
import helper.MessageDialogHelper;
import helper.SharedData;
import model.NguoiDung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class formLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPass;
	private JButton btnCancel;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					formLogin frame = new formLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 344);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Tên đăng nhập");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(219, 10, 136, 34);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtUsername.setBounds(219, 72, 263, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPass = new JLabel("Mật khẩu");
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPass.setBounds(219, 113, 94, 28);
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPass();
			}
		});
		txtPass.setBounds(219, 151, 263, 31);
		contentPane.add(txtPass);

		JLabel lblPicture = new JLabel("");
		lblPicture.setHorizontalAlignment(JLabel.CENTER);
		lblPicture.setBounds(10, 28, 195, 212);
		contentPane.add(lblPicture);

		JSeparator separator = new JSeparator();
		separator.setBounds(219, 218, 242, 2);
		contentPane.add(separator);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPass();
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(219, 233, 136, 21);
		contentPane.add(btnLogin);

		btnCancel = new JButton("Thoát");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCancel.setMnemonic(KeyEvent.VK_X);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCancel.setBounds(376, 233, 106, 21);
		contentPane.add(btnCancel);

		lblPicture.setIcon(new ImageIcon(this.getClass().getResource("/login.png")));

		JLabel btnShow = new JLabel();
		btnShow.setIcon(new ImageIcon(this.getClass().getResource("/eye_16px.png")));

		btnShow.setBounds(244, 192, 16, 16);
		contentPane.add(btnShow);

		JCheckBox checkShow = new JCheckBox("New check box");
		checkShow.setBounds(219, 189, 16, 21);
		contentPane.add(checkShow);
		checkShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkShow.isSelected())
					txtPass.setEchoChar((char) 0);
				else txtPass.setEchoChar((char) UIManager.get("PasswordField.echoChar"));
			}
		});
		
		this.setIconForButton();
	}

	private void checkPass() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtUsername, sb, "Tên đăng nhập không được để trống.");
		DataValidator.validateEmpty(txtPass, sb, "Mật khẩu không được để trống.");
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(this, sb, "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			NguoiDung res = NguoiDungDAO.checkLogin(txtUsername.getText(), new String(txtPass.getPassword()));
			if (res == null)
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác.");
			else {
				MessageDialogHelper.showMessageDialog(this,
						"Bạn đăng nhập thành công vào hệ thống với tư cách: " + res.getVaiTro(),"");
				SharedData.nguoiDangNhap = res;
				MainForm form = new MainForm();
				form.setVisible(true);
				this.dispose();
			}
		} catch (Exception e) {
			MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
		}
	}
	
	public void setIconForButton() {
		btnLogin.setIcon(new ImageIcon(this.getClass().getResource("/next.png")));
		btnCancel.setIcon(new ImageIcon(this.getClass().getResource("/exit.png")));
	}
}
