package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Threading.ThreadCheckTkMk;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginForm extends JDialog {
	private static JTextField txtTK;
	private static JPasswordField txtMK;
	private static JLabel lblCheckMK;
	private static JLabel lblCheckTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			loginForm dialog = new loginForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton btnDangNhap;
	private JCheckBox checkShowPass;
	private JButton btnHuy;

	/**
	 * Create the dialog.
	 */
	public void initJFrame() {
		setBounds(100, 100, 490, 298);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
	}

	public loginForm() {
		this.initJFrame();
		JLabel lblTK = new JLabel("Tài khoản");
		lblTK.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTK.setBounds(175, 78, 77, 20);
		getContentPane().add(lblTK);

		JLabel lblMK = new JLabel("Mật khẩu");
		lblMK.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMK.setBounds(175, 126, 77, 20);
		getContentPane().add(lblMK);

		txtTK = new JTextField();
		txtTK.setBounds(262, 79, 164, 19);
		getContentPane().add(txtTK);
		txtTK.setColumns(10);

		txtMK = new JPasswordField();
		txtMK.setBounds(262, 127, 164, 19);

		getContentPane().add(txtMK);

		JLabel logo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/p1.png"));
		logo.setBounds(20, 61, 118, 101);
		logo.setIcon(img);
		getContentPane().add(logo);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 42, 446, 9);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 193, 446, 9);
		getContentPane().add(separator_1);

		btnDangNhap = new JButton("Đăng nhập");

		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangNhap.setBounds(175, 211, 113, 21);
		getContentPane().add(btnDangNhap);

		btnHuy = new JButton("Huỷ");

		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHuy.setBounds(322, 211, 104, 21);
		getContentPane().add(btnHuy);

		checkShowPass = new JCheckBox("");

		checkShowPass.setBounds(256, 155, 93, 21);
		getContentPane().add(checkShowPass);

		JLabel lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(175, 10, 174, 22);
		getContentPane().add(lblNewLabel_2);

		lblCheckTK = new JLabel("");
		lblCheckTK.setBounds(435, 79, 31, 20);
		getContentPane().add(lblCheckTK);

		lblCheckMK = new JLabel("");
		lblCheckMK.setBounds(436, 126, 31, 20);

		this.addActionListenerMethod();
		getContentPane().add(lblCheckMK);
		txtMK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		ThreadCheckTkMk t = new ThreadCheckTkMk(txtTK, txtMK, lblCheckTK, lblCheckMK);
		t.start();
	}

	public void addActionListenerMethod() {
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		checkShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkShowPass.isSelected())
					txtMK.setEchoChar((char) 0);
				else
					txtMK.setEchoChar((char) UIManager.get("PasswordField.echoChar"));
			}
		});

		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainForm form = new mainForm();
				form.setVisible(true);
			}
		});
	}

	public void checkLogin() {
		String tk = this.txtTK.getText();
		String mk = new String(this.txtMK.getPassword());
		if (tk.equals("") || mk.equals(""))
			JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu đang trống.");
		else {
			if (tk.equals("admin") && mk.equals("admin")) {
				this.setVisible(false);
				JOptionPane.showMessageDialog(this, "Đăng hập thành công");
				UI_Manager ui = new UI_Manager();
				ui.setVisible(true);
			} else {
				txtMK.setBackground(Color.red);
				JOptionPane.showMessageDialog(this, "Thông tin tài khoản hoặc mật khẩu không chính xác.");
			}
		}
	}
}
