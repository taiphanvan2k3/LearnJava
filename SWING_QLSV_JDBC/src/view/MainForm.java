package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helper.SharedData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Color;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JMenuItem menuExit;
	private JMenuItem menuDangXuat;
	private JMenuItem menuQLSV;
	private JMenuItem menuNoiDung;
	private JButton btnDangXuat;
	private JButton btnQLSV;
	private JButton btnQLDiem;
	private JButton btnGioiThieu;
	private studentManagementPanel panelStudent;
	private gpaManagementPanel panelGPA;
	private JTabbedPane tbtPane;
	private JMenuItem menuQLDiem;
	private JLabel lblName;
	private JLabel lblRole;

	/**
	 * Create the frame.
	 */
	public void processLoginSuccess() {
		lblName.setText("Tên đăng nhập:"+SharedData.nguoiDangNhap.getTenDangNhap());
		lblRole.setText("Vai trò:"+SharedData.nguoiDangNhap.getVaiTro());
		if(SharedData.nguoiDangNhap.getVaiTro().equals("Giảng viên")) {
			menuQLSV.setEnabled(false);
		}else if(SharedData.nguoiDangNhap.getVaiTro().equals("Đào tạo")) {
			menuQLDiem.setEnabled(false);
		}
	}

	public MainForm() {
		setType(Type.POPUP);
		setTitle("App Quản Lý Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 768);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuHeThong = new JMenu("Hệ thống");
		menuBar.add(menuHeThong);

		menuDangXuat = new JMenuItem("Đăng Xuất");
		menuDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formLogin login = new formLogin();
				login.setVisible(true);
				setVisible(false);
			}
		});
		menuDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		menuHeThong.add(menuDangXuat);

		JSeparator separator = new JSeparator();
		menuHeThong.add(separator);

		menuExit = new JMenuItem("Thoát");
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		menuHeThong.add(menuExit);

		JMenu menuQuanLy = new JMenu("Quản Lý");
		menuBar.add(menuQuanLy);

		menuQLSV = new JMenuItem("Quản Lý Sinh Viên");
		menuQLSV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		menuQuanLy.add(menuQLSV);

		JSeparator separator_1 = new JSeparator();
		menuQuanLy.add(separator_1);

		menuQLDiem = new JMenuItem("Quản Lý Điểm");
		menuQLDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		menuQuanLy.add(menuQLDiem);

		JMenu menuTroGiup = new JMenu("Trợ Giúp");
		menuBar.add(menuTroGiup);

		menuNoiDung = new JMenuItem("Nội dung");
		menuNoiDung.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
		menuTroGiup.add(menuNoiDung);

		JSeparator separator_2 = new JSeparator();
		menuTroGiup.add(separator_2);

		JMenuItem menuGioiThieu = new JMenuItem("Giới thiệu");
		menuGioiThieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_DOWN_MASK));
		menuTroGiup.add(menuGioiThieu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(250, 250, 210));

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(238, 232, 170));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		toolBar.add(btnDangXuat);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);

		btnQLSV = new JButton("Quản Lý Sinh Viên");
		btnQLSV.setBackground(new Color(238, 232, 170));
		btnQLSV.setFont(new Font("Times New Roman", Font.BOLD, 14));
		toolBar.add(btnQLSV);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_4);

		btnQLDiem = new JButton("Quản Lý Điểm");
		btnQLDiem.setBackground(new Color(238, 232, 170));
		btnQLDiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		toolBar.add(btnQLDiem);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_5);

		btnGioiThieu = new JButton("Giới Thiệu");
		btnGioiThieu.setBackground(new Color(238, 232, 170));

		btnGioiThieu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		toolBar.add(btnGioiThieu);

		tbtPane = new JTabbedPane(JTabbedPane.TOP);

		lblName = new JLabel("");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setToolTipText("");

		lblRole = new JLabel("");
		lblRole.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(tbtPane,
								GroupLayout.PREFERRED_SIZE, 1505, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRole, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 119,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE).addGap(10)
								.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(tbtPane, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		this.addActionListener();
		this.setIconForComponents();
		processLoginSuccess();
	}

	private void addActionListener() {
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menuQLSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelStudent == null) {
					panelStudent = new studentManagementPanel();
					ImageIcon img = new ImageIcon(getClass().getResource("/student2.png"));
					tbtPane.addTab("Quản Lý Sinh Viên", img, panelStudent);
				}
				tbtPane.setSelectedComponent(panelStudent);
			}
		});

		menuQLDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelGPA == null) {
					panelGPA = new gpaManagementPanel();
					ImageIcon img = new ImageIcon(getClass().getResource("/key.png"));
					tbtPane.addTab("Quản Lý Điểm", img, panelGPA);
				}
				tbtPane.setSelectedComponent(panelGPA);
			}
		});

		btnGioiThieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAboutUs();
			}
		});
	}

	private void setIconForComponents() {
		btnDangXuat.setIcon(new ImageIcon(this.getClass().getResource("/logout_32px.png")));
		btnQLSV.setIcon(new ImageIcon(this.getClass().getResource("/student.png")));
		btnQLDiem.setIcon(new ImageIcon(this.getClass().getResource("/folder_32px.png")));
		btnGioiThieu.setIcon(new ImageIcon(this.getClass().getResource("/inform_32px.png")));
		menuDangXuat.setIcon(new ImageIcon(this.getClass().getResource("/logout_24px.png")));
		menuExit.setIcon(new ImageIcon(this.getClass().getResource("/exit.png")));
		menuQLSV.setIcon(new ImageIcon(this.getClass().getResource("/student_24px.png")));
	}

	public void showAboutUs() {
		AboutDialog dialog = new AboutDialog(this, true);
		dialog.setVisible(true);
	}
}
