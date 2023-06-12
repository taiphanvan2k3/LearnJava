package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JToolBar;

public class UI_Manager extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tbtPane;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemSetting;
	private JButton toolbarAddUser;
	private JButton toolbarGPA;
	private JButton toolbarExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Manager frame = new UI_Manager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		tbtPane = new JTabbedPane(JTabbedPane.TOP);
		tbtPane.setBounds(20, 99, 739, 580);
		contentPane.add(tbtPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 0, 195, 22);
		contentPane.add(menuBar);

		JMenu menuItemHeThong = new JMenu("Hệ Thống");
		menuBar.add(menuItemHeThong);

		menuItemSetting = new JMenuItem("Cấu hình");
		menuItemSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbtPane.removeAll();
				JOptionPane.showMessageDialog(contentPane, "Đã xoá các tab pane");
			}
		});
		menuItemHeThong.add(menuItemSetting);

		JSeparator separator = new JSeparator();
		menuItemHeThong.add(separator);

		menuItemExit = new JMenuItem("Thoát");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuItemHeThong.add(menuItemExit);

		JMenu menuQuanLy = new JMenu("Quản Lý");
		menuBar.add(menuQuanLy);

		JMenuItem menuItemQuanLySV = new JMenuItem("Quản Lý Sinh Viên");
		menuItemQuanLySV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageStudentPanel panel = new manageStudentPanel();
				tbtPane.addTab("Quản Lý Sinh Viên", panel);
				tbtPane.setSelectedComponent(panel);
				//tbtPane.removeAll();
			}
		});
		menuQuanLy.add(menuItemQuanLySV);

		JSeparator separator_1 = new JSeparator();
		menuQuanLy.add(separator_1);

		JMenuItem menuItemQLDiem = new JMenuItem("Quản Lý Điểm");
		menuItemQLDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuQuanLy.add(menuItemQLDiem);

		JMenu menuItemHelpContent = new JMenu("Trợ giúp");
		menuBar.add(menuItemHelpContent);

		JMenuItem mntmNewMenuItem = new JMenuItem("Tài Liệu Hướng Dẫn");
		menuItemHelpContent.add(mntmNewMenuItem);

		JSeparator separator_2 = new JSeparator();
		menuItemHelpContent.add(separator_2);

		JMenuItem menuItemHelp = new JMenuItem("Hướng dẫn");
		menuItemHelpContent.add(menuItemHelp);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(20, 32, 155, 57);
		contentPane.add(toolBar);

		toolbarAddUser = new JButton();
		toolBar.add(toolbarAddUser);

		toolbarGPA = new JButton();
		toolBar.add(toolbarGPA);

		toolbarExit = new JButton();
		toolBar.add(toolbarExit);
	}

	public void initJFrame() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		setType(Type.UTILITY);
		setTitle("Quản Lý Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1419, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
	}

	public UI_Manager() {
		this.initJFrame();
		this.initComponents();
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setIcon();
		this.setShortcut();
	}

	public void setIcon() {
		menuItemSetting.setIcon(new ImageIcon(this.getClass().getResource("/setting.png")));
		menuItemExit.setIcon(new ImageIcon(this.getClass().getResource("/exit.png")));
		toolbarAddUser.setIcon(new ImageIcon(this.getClass().getResource("/addUser.png")));
		toolbarExit.setIcon(new ImageIcon(this.getClass().getResource("/exit2.png")));
		toolbarAddUser.setIcon(new ImageIcon(this.getClass().getResource("/addUser.png")));
		toolbarGPA.setIcon(new ImageIcon(this.getClass().getResource("/student.png")));
	}

	public void setShortcut() {
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
	}
	
}
